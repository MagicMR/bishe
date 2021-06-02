package com.magicshroom.bishe.mapper;

import com.magicshroom.bishe.bean.ShopCart;

import java.util.List;

public interface ShopCartMapper {
    void insertShopCart(ShopCart shopCart);

    List<ShopCart> getShopCartListByUserId(String userId);

    String getThumbnailById(String productId);

    void deleteShop(Integer productId, Integer userId);
}
