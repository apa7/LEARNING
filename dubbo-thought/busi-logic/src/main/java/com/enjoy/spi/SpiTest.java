package com.enjoy.spi;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.enjoy.service.InfoService;
import org.junit.Test;

import java.util.ServiceLoader;

public class SpiTest {

    /**
     * java spi机制验证
     */
    @Test
    public void javaSPI() {
        //服务加载器，加载实现类
        ServiceLoader<InfoService> serviceLoader = ServiceLoader.load(InfoService.class);

        //serviceLoader是实现了Iterable的迭代器，直接遍历实现类
        for (InfoService service:serviceLoader){
            Object result = service.sayHello("james");//依次调用实现类
        }
    }

    /**
     * dubbo spi类加载验证
     * extensionLoader.getExtension("a") ---------- 取到对应的扩展类
     * extensionLoader.getDefaultExtension() ------ 取得SPI（"peter"）指定的实现类
     */
    @Test
    public void dubboSPI() {
        //获取InfoService的 Loader 实例
        ExtensionLoader<InfoService> extensionLoader = ExtensionLoader.getExtensionLoader(InfoService.class);
        //取得a拓展类
        InfoService infoServiceA = extensionLoader.getExtension("a");
        infoServiceA.sayHello("james");
        //取得b拓展类
        InfoService infoServiceB = extensionLoader.getDefaultExtension();
        infoServiceB.sayHello("peter");
    }
}
