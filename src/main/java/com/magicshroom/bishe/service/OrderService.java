package com.magicshroom.bishe.service;

import com.magicshroom.bishe.bean.Order;

import java.util.List;

public interface OrderService {
    void addOrderList(List<Order> allProduct, String trade_no);

    List<Order> getOrderListByUid(String userId);
}
