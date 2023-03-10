package com.wza.rpc.common.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class TestController {

    @Autowired HelloController helloController;

    @RequestMapping(value = "sendStringMsg", method = RequestMethod.GET)
    @ResponseBody
    public void sendStringMsg() throws InterruptedException {
        helloController.test2();
    }
}
