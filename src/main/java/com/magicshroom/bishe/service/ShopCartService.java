package com.magicshroom.bishe.service;

import com.magicshroom.bishe.bean.ShopCart;

import java.util.List;
import java.util.Map;

public interface ShopCartService {
    Map<String, Object> addShopCart(ShopCart shopCart);

    List<ShopCart> getShopCartList(String userId);

    void deleteShop(Integer productId, Integer userId);
}
