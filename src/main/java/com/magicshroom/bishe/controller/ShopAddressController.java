package com.magicshroom.bishe.controller;

import com.magicshroom.bishe.bean.ShopAddress;
import com.magicshroom.bishe.service.ShopAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shopAddress")
public class ShopAddressController {

    @Autowired
    ShopAddressService shopAddressService;

    @RequestMapping("addressList")
    public List<ShopAddress> addressList(String userId){
        return shopAddressService.getAddressList(userId);
    }
}
