package com.wza.rpc.common.client.controller;

import com.wza.rpc.common.annotation.RpcReference;

import com.wza.Hello;
import com.wza.HelloService;
import com.wza.rpc.common.annotation.RpcService;
import com.wza.rpc.common.client.client.RpcClient;
import com.wza.rpc.common.client.proxy.RpcClientProxy;
import com.wza.rpc.common.config.RpcServiceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author smile2coder
 */
@Component
public class HelloController {

//    @Autowired
//    RpcClient rpcClient;

    @RpcReference(group = "test1",version = "version1")
    HelloService clientProxy;

    public void test() throws InterruptedException {

//        RpcServiceConfig rpcServiceConfig = RpcServiceConfig.builder()
//                .group("test1")
//                .version("version1").build();
//        RpcClientProxy rpcClientProxy = new RpcClientProxy(rpcClient, rpcServiceConfig);
//        clientProxy = rpcClientProxy.getProxy(HelloService.class);

        String hello = clientProxy.hello(new Hello("111", "222"));
        //如需使用 assert 断言，需要在 VM options 添加参数：-ea
        assert "Hello description is 222".equals(hello);
        Thread.sleep(12000);
        for (int i = 0; i < 10; i++) {
            System.out.println(clientProxy.hello(new Hello("111", "222")));
        }
    }

    public void test2() throws InterruptedException {

        String hello = clientProxy.hello(new Hello("111", "222"));
    }
}
