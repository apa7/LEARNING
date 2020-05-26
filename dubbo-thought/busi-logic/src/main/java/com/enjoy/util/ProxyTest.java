package com.enjoy.util;

import com.alibaba.dubbo.common.extension.ExtensionFactory;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcResult;
import com.alibaba.dubbo.rpc.protocol.AbstractInvoker;
import com.alibaba.dubbo.rpc.proxy.javassist.JavassistProxyFactory;
import com.alibaba.dubbo.rpc.proxy.jdk.JdkProxyFactory;
import com.enjoy.service.DemoService;
import com.enjoy.service.DemoServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * dubbo中的动态代理
 */
public class ProxyTest {

    /**
     * 封装目标服务为统一 Invoker
     */
    //消费服务
    private Invoker<DemoService> invoker = new AbstractInvoker(DemoService.class, ProtocolUtil.RMI_URL) {
        @Override
        protected Result doInvoke(Invocation invocation) throws Throwable {
            Object[] objects = invocation.getArguments();
            DemoService demoService = new DemoServiceImpl();
            Object o = demoService.sayHello((String) objects[0]);
            return new RpcResult(o);
        }
    };

    /**
     * jdk动态代理
     */
    @Test
    public void JdkProxyTest(){
        //动态代理
        JdkProxyFactory proxy = new JdkProxyFactory();

        DemoService service = proxy.getProxy(invoker,new Class[]{DemoService.class});
        String result = service.sayHello("peter");
        System.out.println(result);

    }

    /**
     * javassist静态代理
     */
    @Test
    public void javassistProxyTest(){
        //动态代理
        JavassistProxyFactory proxy = new JavassistProxyFactory();

        DemoService service = proxy.getProxy(invoker,new Class[]{DemoService.class});
        String result = service.sayHello("peter");
        System.out.println(result);

    }

    public static void main(String[] args) {
        ExtensionLoader<ExtensionFactory> loader = ExtensionLoader.getExtensionLoader(ExtensionFactory.class);
        List<ExtensionFactory> list = new ArrayList<ExtensionFactory>();
        for (String name : loader.getSupportedExtensions()) {
            list.add(loader.getExtension(name));
        }
    }
}
