package com.enjoy;

import com.enjoy.service.DemoService;
import com.enjoy.service.DemoServiceImpl;
import org.junit.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanDefinitionTest {
    /**
     * Spring注册Bean的过程
     */
    @Test
    public void JdkProxyTest(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
        applicationContext.start();

        //测试原配bean功能
        DemoService configService = (DemoService)applicationContext.getBean("configService");
        configService.sayHello("peter");

        // 定义Bean信息
//        GenericBeanDefinition parentBeanDef = new GenericBeanDefinition();
        RootBeanDefinition beanDef = new RootBeanDefinition();

        beanDef.setBeanClass(DemoServiceImpl.class);
        beanDef.setBeanClassName(DemoServiceImpl.class.getName());
        beanDef.setScope(BeanDefinition.SCOPE_SINGLETON);//单例

        //设置属性
        MutablePropertyValues propertyValues = beanDef.getPropertyValues();
        propertyValues.addPropertyValue("type","runtime");

        //注册bean
        applicationContext.registerBeanDefinition("demoService", beanDef);

        //测试刚注册的bean功能
        DemoService demoService = (DemoService)applicationContext.getBean("demoService");
        demoService.sayHello("peter");
    }

    @Configuration
    static class TestConfiguration {
        @Bean
        public DemoService configService() {
            return new DemoServiceImpl();
        }
    }


}
