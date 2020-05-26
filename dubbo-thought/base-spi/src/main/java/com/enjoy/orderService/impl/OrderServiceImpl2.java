package com.enjoy.orderService.impl;


import com.alibaba.dubbo.common.URL;
import com.enjoy.service.OrderService;
import com.enjoy.service.PayService;

public class OrderServiceImpl2 implements OrderService {
    private PayService payService;

    public void setPayService(PayService payService) {
        this.payService = payService;
    }

    @Override
    public String getDetail(String name, URL url) {
        payService.pay(100);
        System.out.println(name+",OrderServiceImpl2订单处理成功！");
        return name+",你好，OrderServiceImpl2订单处理成功！";
    }
}
