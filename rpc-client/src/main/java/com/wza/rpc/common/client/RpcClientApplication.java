package com.wza.rpc.common.client;

import com.wza.Hello;
import com.wza.rpc.common.client.controller.HelloController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RpcClientApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RpcClientApplication.class, args);
    }

    @Autowired
    HelloController helloController;

    @Override
    public void run(String... args) throws Exception {
        helloController.test();
    }
}
