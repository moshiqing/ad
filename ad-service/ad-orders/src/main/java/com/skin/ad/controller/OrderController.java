package com.skin.ad.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Order")
public class OrderController {

    @RequestMapping("/test")
    public String test(){
        return "Order is success";
    }

}
