package com.example.rpc.server;

import com.example.rpc.server.server.RpcServer;
import com.example.rpc.server.serviceImpl.HelloServiceImpl;
import com.wza.HelloService;
import com.wza.rpc.common.config.RpcServiceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RpcServerApplication implements CommandLineRunner {

    @Autowired
    RpcServer rpcServer;

    public static void main(String[] args) {
        SpringApplication.run(RpcServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        new Thread(()->{
            HelloService helloService = new HelloServiceImpl();
            RpcServiceConfig rpcServiceConfig = RpcServiceConfig.builder()
                    .group("test1").version("version1").service(helloService).build();
            rpcServer.registerService(rpcServiceConfig);
        }).start();

    }
}
