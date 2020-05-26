package com.enjoy.dubbospi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.Filter;
import org.junit.Test;

import java.util.List;

/**
 * 某此情况下，同一个接口的多个实现需要同时发挥作用，比如filter链。此时需要按条件选择一批实现类来工作
 * Activate：可以被框架中自动激活加载扩展
 * 用户通过group和value配置激活条件
 * group 分组(筛选条件)
 * value url中包含的key名(筛选条件)
 * order 排序
 *
 * 下面以filter过滤器为例讲解
 * 1.如果需要在服务暴露时装载，那么group="provider"
 * 2.如果需要在服务引用的时候装载，那么group="consumer"
 * 3.如果想被暴露和引用时同时被装载，那么group={"consumer", "provider"}
 * 4.如果需要url中有某个特定的值才被加载，那么value={"test5", "test"}
 */
public class ActivateTest {

    /**
     * 调用分组为peter过滤器
     */
    @Test
    public void testActivate1() {
        ExtensionLoader<Filter> extensionLoader = ExtensionLoader.getExtensionLoader(Filter.class);

        URL url = URL.valueOf("test://localhost/test");
        List<Filter> list=extensionLoader.getActivateExtension(url,"", "peter");//group
        for (Filter filter:list){
            filter.invoke(null,null);
        }
    }

    /**
     * 分组为james
     * url中有参数groupId
     */
    @Test
    public void testActivate2() {
        ExtensionLoader extensionLoader = ExtensionLoader.getExtensionLoader(Filter.class);

        URL url = URL.valueOf("test://localhost/dsafsdfsdfsd");
        url = url.addParameter("oooooo", "66666");
        List<Filter> list = extensionLoader.getActivateExtension(url,"","james");
        for (Filter filter:list){
            filter.invoke(null,null);
        }
    }

    /**
     * 分组为peter
     * url中有参数groupId
     * url中指定要使用a,去除c实现
     */
    @Test
    public void testActivate3() {
        ExtensionLoader extensionLoader = ExtensionLoader.getExtensionLoader(Filter.class);

        URL url = URL.valueOf("test://localhost/test");
        url = url.addParameter("groupId", "qqqq");
        url = url.addParameter("myfilter", "a,-c");

        List<Filter> list = extensionLoader.getActivateExtension(url,"myfilter","peter");
        for (Filter filter:list){
            filter.invoke(null,null);
        }
    }
}
