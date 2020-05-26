package com.enjoy.util;

import com.alibaba.dubbo.rpc.Exporter;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Protocol;
import com.alibaba.dubbo.rpc.proxy.jdk.JdkProxyFactory;
import com.enjoy.service.DemoService;
import com.enjoy.service.DemoServiceImpl;
import com.enjoy.util.ProtocolUtil;
import org.junit.Test;

import java.io.IOException;

public class DubboRpcTest {

    @Test
    public void rpcServer() throws IOException {
        DemoService service = new DemoServiceImpl();

        //动态代理
        JdkProxyFactory proxy = new JdkProxyFactory();
        //协议
        Protocol protocol = ProtocolUtil.getRmiProtocol(proxy);

        //暴露对象
        Invoker<DemoService> serviceInvoker = proxy.getInvoker(service, DemoService.class, ProtocolUtil.RMI_URL);
        //监听网络请求，路由到暴露对象
        Exporter<DemoService> exporter = protocol.export(serviceInvoker);

        System.out.println("Dubbo server 启动");
        // 保证服务一直开着
        System.in.read();
        exporter.unexport();
    }

    @Test
    public void rpcClient() {
        //动态代理
        JdkProxyFactory proxy = new JdkProxyFactory();
        //协议
        Protocol protocol = ProtocolUtil.getRmiProtocol(proxy);

        //消费服务
        Invoker<DemoService> referInvoker = protocol.refer(DemoService.class, ProtocolUtil.RMI_URL);
        DemoService service = proxy.getProxy(referInvoker);

        String result = service.sayHello("peter");
        System.out.println(result);

        referInvoker.destroy();

    }


}
