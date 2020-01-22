package com.skin.ad.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "ad-orders",path = "/Order")
public interface OrdersClient {

    @RequestMapping("/test")
    String test();
}
