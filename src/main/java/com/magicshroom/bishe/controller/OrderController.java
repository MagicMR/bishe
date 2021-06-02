package com.magicshroom.bishe.controller;

import com.magicshroom.bishe.bean.Order;
import com.magicshroom.bishe.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 27250
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 获取订单列表
     * @param userId 用户Id
     * @return 该用户的订单列表
     */
    @RequestMapping("/orderListByUid")
    public List<Order> orderListByUid(String userId){
        return orderService.getOrderListByUid(userId);
    }
}
