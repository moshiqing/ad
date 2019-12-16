package com.skin.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringCloudApplication
@EnableZuulProxy
public class gatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(gatewayApplication.class,args);
    }
}
