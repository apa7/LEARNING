/*
 *
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to You under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package com.enjoy;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.enjoy.service.InfoService;
import com.enjoy.service.OrderService;
import com.enjoy.service.PayService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanSpringSpiTest {

    @Test
    public void iocSPI() {
        //获取OrderService的 Loader 实例
        ExtensionLoader<OrderService> loader = ExtensionLoader.getExtensionLoader(OrderService.class);
        //取得默认拓展类
        OrderService orderService = loader.getDefaultExtension();
        URL url = URL.valueOf("test://localhost/test?info.service=b");
        orderService.getDetail("peter",url);
    }

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        context.start();
        System.out.println("---------dubbo启动成功--------");
        //获取OrderService的 Loader 实例
        ExtensionLoader<OrderService> loader = ExtensionLoader.getExtensionLoader(OrderService.class);
        //取得拓展类2
        OrderService orderService = loader.getExtension("james");
        URL url = URL.valueOf("test://localhost/test?info.service=b");
        orderService.getDetail("peter",url);
//        System.in.read();
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "com.enjoy.service")
    static class ProviderConfiguration {
        @Bean
        public PayService payService() {
            PayService payService = new PayService(){
                @Override
                public String pay(long money) {
                    System.out.println("payService调用成功");
                    return "peter,money:"+money;
                }
            };
            return payService;
        }
        @Bean
        public ProviderConfig providerConfig() {
            ProviderConfig providerConfig = new ProviderConfig();
            providerConfig.setTimeout(1000);
            return providerConfig;
        }

        @Bean
        public ApplicationConfig applicationConfig() {
            ApplicationConfig applicationConfig = new ApplicationConfig();
            applicationConfig.setName("busi-provider");
            return applicationConfig;
        }

        @Bean
        public RegistryConfig registryConfig() {
            RegistryConfig registryConfig = new RegistryConfig();
            registryConfig.setProtocol("zookeeper");
            registryConfig.setAddress("127.0.0.1");
            registryConfig.setPort(2181);
            return registryConfig;
        }

        @Bean
        public ProtocolConfig protocolConfig() {
            ProtocolConfig protocolConfig = new ProtocolConfig();
            protocolConfig.setName("dubbo");
            protocolConfig.setPort(20880);
            return protocolConfig;
        }
    }

}
