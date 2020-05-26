package com.enjoy.filter.impl;


import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;

/**
 * 使用方传递了group = Constants.PROVIDER 或者Constants.CONSUMER则该Filter激活
 */
@Activate(group = {Constants.PROVIDER, Constants.CONSUMER})
public class FilterA implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("你好，调通了Filer A实现！");
        return invoker.invoke(invocation);
    }
}
