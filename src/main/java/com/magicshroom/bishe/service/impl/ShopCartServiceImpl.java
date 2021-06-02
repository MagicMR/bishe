package com.magicshroom.bishe.service.impl;

import com.magicshroom.bishe.bean.ShopCart;
import com.magicshroom.bishe.mapper.ShopCartMapper;
import com.magicshroom.bishe.service.ShopCartService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Service
@Log
public class ShopCartServiceImpl implements ShopCartService {

    @Autowired
    ShopCartMapper shopCartMapper;

    @Override
    public Map<String, Object> addShopCart(ShopCart shopCart) {
        Map<String,Object> map = new HashMap<>();
        shopCartMapper.insertShopCart(shopCart);
        map.put("success",true);
        map.put("msg","加入成功！！");
        return map;
    }

    @Override
    public List<ShopCart> getShopCartList(String userId) {
        List<ShopCart> cartList = shopCartMapper.getShopCartListByUserId(userId);
        for (ShopCart shopCart : cartList) {
            String productId = shopCart.getProductId();
            shopCart.setImgPath(shopCartMapper.getThumbnailById(productId));
        }
        return cartList;
    }

    @Override
    public void deleteShop(Integer productId, Integer userId) {
        shopCartMapper.deleteShop(productId,userId);
    }
}
