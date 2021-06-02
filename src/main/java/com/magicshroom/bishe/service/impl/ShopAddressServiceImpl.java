package com.magicshroom.bishe.service.impl;

import com.magicshroom.bishe.bean.ShopAddress;
import com.magicshroom.bishe.mapper.ShopAddressMapper;
import com.magicshroom.bishe.service.ShopAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ShopAddressServiceImpl implements ShopAddressService {

    @Autowired
    ShopAddressMapper shopAddressMapper;

    @Override
    public List<ShopAddress> getAddressList(String userId) {
        return shopAddressMapper.getAddressList(userId);
    }
}
