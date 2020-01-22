package com.skin.ad.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.skin.ad.feignClient.OrdersClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private OrdersClient ordersClient;

    @RequestMapping("/test")
    @HystrixCommand
    public String test(){
        return "user is success";
    }

    @RequestMapping("/userTestOrders")
    @HystrixCommand
    public String userTestOrders(){
        return ordersClient.test();
    }

}
