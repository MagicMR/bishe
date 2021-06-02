package com.magicshroom.bishe.mapper;

import com.magicshroom.bishe.bean.Order;

import java.util.List;

public interface OrderMapper {
    /**
     * 添加一条订单记录
     * @param order 订单
     */
    void insertOrder(Order order);

    /**
     * 通过用户id查找所有的订单
     * @param userId 用户id
     * @return 订单列表
     */
    List<Order> selectByUserId(String userId);
}
