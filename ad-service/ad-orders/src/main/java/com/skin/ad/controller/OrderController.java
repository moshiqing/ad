package com.skin.ad.controller;

import com.skin.ad.entity.orders;
import com.skin.ad.mapper.ordersMapper;
import io.seata.core.context.RootContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/Order")
public class OrderController {

    @Resource
    private ordersMapper orderMapper;

    @RequestMapping("/test")
    public String test(){
        return "Order is success";
    }

    @RequestMapping("/saveOrder")
    @Transactional
    public String saveOrder(@RequestParam("flag") Integer flag){
        System.out.println("flag:::"+flag);
        orders o=new orders();
        o.setName("dawd");
        int i=orderMapper.insert(o);
        System.out.println("flag:::"+flag);
        if(flag==0){
            throw new RuntimeException("xid="+ RootContext.getXID());

        }
        return "操作order成功"+i;
    }

}
