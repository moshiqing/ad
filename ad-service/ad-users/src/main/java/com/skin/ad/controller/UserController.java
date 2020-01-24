package com.skin.ad.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.skin.ad.entity.users;
import com.skin.ad.feignClient.OrdersClient;
import com.skin.ad.mapper.UsersMapper;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private OrdersClient ordersClient;

    @Resource
    private UsersMapper usersMapper;

    @RequestMapping("/test")
    @HystrixCommand
    public String test(){
        return "users is success";
    }

    @RequestMapping("/userTestOrders")
    @HystrixCommand
    public String userTestOrders(){
        return ordersClient.test();
    }

    @RequestMapping("/saveUser")
    @HystrixCommand
    public void saveUser(){
        users u=new users();
        u.setName("test");
        usersMapper.insert(u);
        ordersClient.saveOrder(2);
    }


    @RequestMapping("/saveUserAndOrder")
    @HystrixCommand
    @GlobalTransactional(name = "save_user_create_order")
    @Transactional
    public void saveUserAndOrder(Integer flag){
        System.out.println("flag:::"+flag);
        users u=new users();
        u.setName("test");
        usersMapper.insert(u);
        String str=ordersClient.saveOrder(flag);
        System.out.println("flag:::"+flag);
        if(flag==1){
            throw new RuntimeException("操作事务失败引起混滚:"+ RootContext.getXID());
        }
    }
}
