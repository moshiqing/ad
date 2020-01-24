package com.skin.ad.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "ad-orders",path = "/Order")
public interface OrdersClient {

    @RequestMapping("/test")
    String test();

    @RequestMapping("/saveOrder")
    String saveOrder(@RequestParam("flag") Integer flag);
}
