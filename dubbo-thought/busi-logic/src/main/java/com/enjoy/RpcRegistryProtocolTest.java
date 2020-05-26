package com.enjoy;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.registry.RegistryFactory;
import com.alibaba.dubbo.registry.integration.RegistryProtocol;
import com.alibaba.dubbo.remoting.exchange.ExchangeClient;
import com.alibaba.dubbo.rpc.*;
import com.alibaba.dubbo.rpc.cluster.support.FailfastCluster;
import com.alibaba.dubbo.rpc.protocol.dubbo.DubboInvoker;
import com.alibaba.dubbo.rpc.protocol.dubbo.DubboProtocol;
import com.enjoy.protocol.RmiProtocol;
import com.enjoy.protocol.SimpleInvoker;
import com.enjoy.service.DemoService;
import com.enjoy.service.DemoServiceImpl;
import com.enjoy.service.ZkDemoServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

/**
 * 注册中心动态服务
 */
public class RpcRegistryProtocolTest {
    ExtensionLoader<Protocol> protocolLoader = ExtensionLoader.getExtensionLoader(Protocol.class);
    ExtensionLoader<ProxyFactory> proxyLoader = ExtensionLoader.getExtensionLoader(ProxyFactory.class);

    //注册中心服务--zk
    final URL registryUrl = URL.valueOf("registry://127.0.0.1:2181/com.alibaba.dubbo.registry.RegistryService?registry=zookeeper");

    //支付的协议：dubbo,http,hessian,rmi
    URL serviceUrl = URL.valueOf("dubbo://127.0.0.1:9001/com.enjoy.service.DemoService");
    @Test
    public void serverRpc() throws IOException {
        DemoService service = new ZkDemoServiceImpl("peter");
        Protocol protocol = protocolLoader.getAdaptiveExtension();
        //动态代理
        ProxyFactory proxy = proxyLoader.getAdaptiveExtension();

        serviceUrl = serviceUrl.setPort(9001);
        serviceUrl = serviceUrl.addParameter("loadbalance","first");
        serviceUrl = serviceUrl.addParameter("cluster","failsms");
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
    public void serverRpc2() throws IOException {
        DemoService service = new ZkDemoServiceImpl("james");
        Protocol protocol = protocolLoader.getAdaptiveExtension();
        //动态代理
        ProxyFactory proxy = proxyLoader.getAdaptiveExtension();

        serviceUrl = serviceUrl.setPort(9002);
        serviceUrl = serviceUrl.addParameter("loadbalance","first");
        serviceUrl = serviceUrl.addParameter("cluster","failsms");
        URL newRegistryUrl = registryUrl.addParameter(Constants.EXPORT_KEY, serviceUrl.toFullString());
        //暴露服务
        Invoker<DemoService> serviceInvoker = proxy.getInvoker(service, DemoService.class, newRegistryUrl);
        Exporter<DemoService> exporter = protocol.export(serviceInvoker);
        System.out.println("server 启动协议："+serviceUrl.getProtocol());
        // 保证服务一直开着
        System.in.read();
        exporter.unexport();
    }

//    @Reference(cluster = "",loadbalance = )
    @Test
    public void clientRpc() throws IOException {
        Protocol protocol = protocolLoader.getAdaptiveExtension();
        //动态代理
        ProxyFactory proxy = proxyLoader.getAdaptiveExtension();
        //消费服务
        Invoker<DemoService> referInvoker = protocol.refer(DemoService.class, registryUrl);
        DemoService service = proxy.getProxy(referInvoker);

        for (int i = 0;i < 5;i++){
            String result = service.sayHello(registryUrl.getProtocol()+"调用");
            System.out.println(result);
        }
        // 保证服务一直开着
//        System.in.read();

    }

}
