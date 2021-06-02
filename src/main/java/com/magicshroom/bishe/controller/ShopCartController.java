package com.magicshroom.bishe.controller;

import com.magicshroom.bishe.bean.ShopCart;
import com.magicshroom.bishe.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shopCart")
public class ShopCartController {

    @Autowired
    ShopCartService shopCartService;

    @RequestMapping("/addShopCart")
    public Map<String,Object> addShopCart(ShopCart shopCart){
        System.out.println(shopCart);
        return shopCartService.addShopCart(shopCart);
    }

    @RequestMapping("/shopCartList")
    public List<ShopCart> shopCartList(String userId){
        return shopCartService.getShopCartList(userId);
    }

    @RequestMapping("/deleteShop")
    public Boolean deleteShop(Integer productId,Integer userId){
        shopCartService.deleteShop(productId,userId);
        return true;
    }
}
