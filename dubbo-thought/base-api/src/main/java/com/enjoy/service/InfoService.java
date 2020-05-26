package com.enjoy.service;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

import java.rmi.RemoteException;
import java.util.Map;

/**
 * SPI 全称为 Service Provider Interface，是一种服务发现机制，目标是为接口寻找实现类。
 * Java SPI 的作法：
 * 		1.在类路径下META-INF/service下创建文件，名称为接口的全限定名。
 * 		2.将接口实现类的全限定名配置在文件中
 * 		3.服务启动时，将由服务加载器读取配置文件，并加载实现类。
 *
 * Dubbo SPI的作法：
 * 		1.Dubbo 增强原生的SPI机制来更好的满足拓展要求，其以键值对的方式对接口的实现进行配置管理。
 * 		2.Dubbo引入三个注解： SPI、Adaptive和Activate。
 *
 * 	只有标注了SPI注解的接口，才是Dubbo的菜
 */
@SPI("b")
public interface InfoService {
	Object sayHello(String name) ;
	@Adaptive({"mark"})
//	@Adaptive
	Object passInfo(String msg, URL url) ;
}
