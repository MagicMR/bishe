package com.magicshroom.bishe.service.impl;

import com.magicshroom.bishe.bean.Order;
import com.magicshroom.bishe.bean.Thumbnail;
import com.magicshroom.bishe.mapper.OrderMapper;
import com.magicshroom.bishe.mapper.ThumbnailMapper;
import com.magicshroom.bishe.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ThumbnailMapper thumbnailMapper;

    @Override
    public void addOrderList(List<Order> allProduct, String trade_no) {
        for (Order order : allProduct) {
            order.setPayTradeNo(trade_no);
            orderMapper.insertOrder(order);
        }
    }

    /**
     * 通过用户ID获取订单列表
     * @param userId 用户id
     * @return 订单列表
     */
    @Override
    public List<Order> getOrderListByUid(String userId) {
        List<Order> orders = orderMapper.selectByUserId(userId);
        for (Order order : orders) {
            order.setImgPath(thumbnailMapper.selectImgPathByPid(order.getProductId()));
        }
        return orders;
    }
}
