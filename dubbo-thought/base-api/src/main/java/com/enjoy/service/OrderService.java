package com.enjoy.service;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.SPI;

@SPI("peter")
public interface OrderService {
    String getDetail(String id, URL url);
}
