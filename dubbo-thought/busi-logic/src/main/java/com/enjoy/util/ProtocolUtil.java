package com.enjoy.util;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.remoting.http.HttpBinder;
import com.alibaba.dubbo.remoting.http.jetty.JettyHttpBinder;
import com.alibaba.dubbo.rpc.Exporter;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Protocol;
import com.alibaba.dubbo.rpc.ProxyFactory;
import com.alibaba.dubbo.rpc.protocol.dubbo.DubboProtocol;
import com.alibaba.dubbo.rpc.protocol.http.HttpProtocol;
import com.alibaba.dubbo.rpc.protocol.rmi.RmiProtocol;
import com.alibaba.dubbo.rpc.proxy.jdk.JdkProxyFactory;
import com.enjoy.service.DemoService;
import com.enjoy.service.DemoServiceImpl;
import org.junit.Test;

public class ProtocolUtil {

    //http协议
    public static URL HTTP_URL = URL.valueOf("http://127.0.0.1:9010/" + DemoService.class.getName());
    public static Protocol getHttpProtocol(ProxyFactory proxy){
        HttpBinder binder = new JettyHttpBinder();
        HttpProtocol protocol = new HttpProtocol();

        protocol.setHttpBinder(binder);
        protocol.setProxyFactory(proxy);

        return protocol;
    }

    //rest协议
    public static URL RMI_URL = URL.valueOf("rmi://127.0.0.1:9001/"+ DemoService.class.getName());
    public static Protocol getRmiProtocol(ProxyFactory proxy){
        RmiProtocol protocol = new RmiProtocol();
        protocol.setProxyFactory(proxy);

        return protocol;
    }

    //dubbo协议
    public static URL DUBBO_URL = URL.valueOf("dubbo://127.0.0.1:9010/" + DemoService.class.getName());
    public static Protocol getDubboProtocol(ProxyFactory... proxy){
        return new DubboProtocol();
    }

}
