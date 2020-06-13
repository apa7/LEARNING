package com.enjoy.cluster;

import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.cluster.Cluster;
import com.alibaba.dubbo.rpc.cluster.Directory;
import com.alibaba.dubbo.rpc.cluster.support.FailfastClusterInvoker;

public class FailSmsCluster implements Cluster {

    @Override
    public <T> Invoker<T> join(Directory<T> directory) throws RpcException {
        sendSms();
        return new FailfastClusterInvoker<>(directory);
    }

    private void sendSms(){
        System.out.println("send sms notify！");
    }
}
