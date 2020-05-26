package com.enjoy.orderService.impl;


import com.alibaba.dubbo.common.URL;
import com.enjoy.service.InfoService;
import com.enjoy.service.OrderService;

public class OrderServiceImpl implements OrderService {
    private InfoService infoService;//是dubbo的扩展点，是spring的bean接口

    public void setInfoService(InfoService infoService) {
        this.infoService = infoService;
    }

    @Override
    public String getDetail(String name, URL url) {
        infoService.passInfo(name,url);
        System.out.println(name+",OrderServiceImpl订单处理成功！");
        return name+",你好，OrderServiceImpl订单处理成功！";
    }
}
