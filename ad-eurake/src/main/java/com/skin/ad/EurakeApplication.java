package com.skin.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class eurakeApplication {

    public static void main(String[] args) {

        SpringApplication.run(eurakeApplication.class,args);
    }
}
