package com.enjoy.infoService.impl;


import com.alibaba.dubbo.common.URL;
import com.enjoy.service.InfoService;

//@Adaptive
public class InfoServiceCImpl implements InfoService {

    @Override
    public Object sayHello(String name) {
        System.out.println(name+",你好，调通了C实现！");
        return name+",你好，调通了C实现！";
    }

    @Override
    public Object passInfo(String msg, URL url) {
        System.out.println("恭喜你，调通了C实现");
        return msg;
    }

}
