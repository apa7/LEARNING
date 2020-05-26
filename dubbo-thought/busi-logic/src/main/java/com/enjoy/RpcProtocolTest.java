package com.enjoy;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.Exporter;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Protocol;
import com.alibaba.dubbo.rpc.proxy.InvokerInvocationHandler;
import com.alibaba.dubbo.rpc.proxy.jdk.JdkProxyFactory;
import com.enjoy.protocol.RmiProtocol;
import com.enjoy.protocol.SimpleInvoker;
import com.enjoy.service.DemoService;
import com.enjoy.service.DemoServiceImpl;
import com.enjoy.util.ProtocolUtil;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Proxy;

public class RpcProtocolTest {
    URL url = URL.valueOf("rmi://127.0.0.1:9001/"+ DemoService.class.getName());

    /**
     * Protocol连接服务端invoker
     * 将目标服务调用信息，包装成为invoker实体，暴露到网络上
     *
     * 当网络信息到达，将触发invoker的invoke方法，最终将调用转到目标service上
     */
    @Test
    public void invoker2protocol() throws IOException {
        DemoService service = new DemoServiceImpl();

        Invoker<DemoService> invoker = new SimpleInvoker(service,DemoService.class,url);
        Protocol protocol = new RmiProtocol();
        //暴露对象
        protocol.export(invoker);
        System.out.println("Dubbo server 启动");
        // 保证服务一直开着
        System.in.read();
    }

    /**
     * Protocol连接消费端invoker
     * 将要调用的信息，包装成invoker实体，向网络发送
     *
     * 本地调用接口代理时，最终方法被转到invoker的invoke方法上，向网络发送
     */
    @Test
    public void protocol2Invoker() {
        //协议
        Protocol protocol = new RmiProtocol();

        //消费invoker，负责发送协议调用信息
        Invoker<DemoService> invoker = protocol.refer(DemoService.class, url);

        //做一个动态代理，将调用目标指向invoker即可
        DemoService service = (DemoService)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{invoker.getInterface()},
                new InvokerInvocationHandler(invoker));//反射逻辑

        String result = service.sayHello("peter");
        System.out.println(result);


    }


}
