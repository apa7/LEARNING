package com.enjoy.filter.impl;


import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;

/**
 * 使用方传递了group = peter或james 则该Filter激活
 */
@Activate(group = {"peter","james"},order = 4)
public class FilterD implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("你好，调通了Filer D实现！");
        return null;
    }
}
