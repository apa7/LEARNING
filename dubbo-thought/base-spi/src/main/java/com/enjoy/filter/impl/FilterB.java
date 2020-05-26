package com.enjoy.filter.impl;


import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;

/**
 * 使用方传递了group = james 则该Filter激活
 */
@Activate(group = "james",order = 2)
public class FilterB implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("你好，调通了Filer B实现！");
        return invoker.invoke(invocation);
    }
}
