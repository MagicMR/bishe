package com.magicshroom.bishe.service;

import com.magicshroom.bishe.bean.ShopAddress;

import java.util.List;

public interface ShopAddressService {
    List<ShopAddress> getAddressList(String userId);
}
