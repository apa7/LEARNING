package com.enjoy;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.*;
import com.enjoy.filter.impl.FilterB;
import com.enjoy.service.DemoService;
import com.enjoy.service.ZkDemoServiceImpl;
import java.io.IOException;
import org.junit.Test;

public class RpcSPITestFilter {
    Protocol protocol = ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();
    //动态代理
    ProxyFactory proxy = ExtensionLoader.getExtensionLoader(ProxyFactory.class).getAdaptiveExtension();

    //注册中心服务--zk
    final URL registryUrl = URL.valueOf("registry://127.0.0.1:2181/com.alibaba.dubbo.registry.RegistryService?registry=zookeeper");

    //支付的协议：dubbo,http,hessian,rmi
    URL serviceUrl = URL.valueOf("dubbo://127.0.0.1:9001/com.enjoy.service.DemoService");
    @Test
    public void serverRpc() throws IOException {
        DemoService service = new ZkDemoServiceImpl("peter");
        serviceUrl = serviceUrl.setPort(9001);
        URL newRegistryUrl = registryUrl.addParameter(Constants.EXPORT_KEY, serviceUrl.toFullString());
        //暴露服务
        Invoker<DemoService> serviceInvoker = proxy.getInvoker(service, DemoService.class, newRegistryUrl);
        Exporter<DemoService> exporter = protocol.export(serviceInvoker);
        System.out.println("server 启动协议："+serviceUrl.getProtocol());
        // 保证服务一直开着
        System.in.read();
        exporter.unexport();
    }

    @Test
    public void clientRpc() throws IOException {
        Invoker<DemoService> referInvoker = protocol.refer(DemoService.class, registryUrl);
        //@----代理方式
        DemoService service = proxy.getProxy(referInvoker);
        String result = service.sayHello(registryUrl.getProtocol()+"调用");
        System.out.println(result);
    }

    @Test
    public void clientInvoker() throws IOException {
        Invoker<DemoService> referInvoker = protocol.refer(DemoService.class, registryUrl);

        //@----直接调用方式
        Invocation invocation = new RpcInvocation(
                "sayHello",new Class<?>[]{String.class},new Object[]{"invoke直接调用"},null);
        Result result2 =  referInvoker.invoke(invocation);
        System.out.println(result2.getValue());
    }

    private Invocation invocation = new RpcInvocation(
            "sayHello",new Class<?>[]{String.class},new Object[]{"invoke调用"},null);

    @Test
    public void clientInvokerwrapper() throws IOException {
        Invoker<DemoService> referInvoker = protocol.refer(DemoService.class, registryUrl);

        //@----再嵌套一次调用方式
        Invoker<DemoService> invoker = new Invoker<DemoService>() {
            private Invoker<DemoService> invoker = referInvoker;
            @Override
            public Class<DemoService> getInterface() {
                return invoker.getInterface();
            }

            @Override
            public Result invoke(Invocation invocation) throws RpcException {
                System.out.println("invoker嵌套调用");
                return invoker.invoke(invocation);
            }

            @Override
            public URL getUrl() {
                return invoker.getUrl();
            }

            @Override
            public boolean isAvailable() {
                return false;
            }

            @Override
            public void destroy() {

            }
        };

        Result result3 =  invoker.invoke(invocation);
        System.out.println(result3.getValue());
    }

    @Test
    public void clientInvokerFilter() throws IOException {
        Invoker<DemoService> referInvoker = protocol.refer(DemoService.class, registryUrl);

        //@----filter调用方式
//        Filter filterB = ExtensionLoader.getExtensionLoader(Filter.class).getExtension("b");
        Filter filterB = new FilterB();
        Result result4 = filterB.invoke(referInvoker,invocation);
        System.out.println(result4.getValue());

        //@---将filter组装成invoker
        Invoker<DemoService> filterInvoker = new Invoker<DemoService>() {
            private Invoker<DemoService> invoker = referInvoker;
            @Override
            public Class<DemoService> getInterface() {
                return invoker.getInterface();
            }

            @Override
            public Result invoke(Invocation invocation) throws RpcException {
                System.out.println("filterInvoker被调用");
                return filterB.invoke(invoker,invocation);
            }

            @Override
            public URL getUrl() {
                return invoker.getUrl();
            }

            @Override
            public boolean isAvailable() {
                return false;
            }

            @Override
            public void destroy() {

            }
        };
        Result result5 = filterInvoker.invoke(invocation);
        System.out.println(result5.getValue());

    }


}
