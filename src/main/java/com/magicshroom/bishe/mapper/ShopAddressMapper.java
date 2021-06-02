package com.magicshroom.bishe.mapper;

import com.magicshroom.bishe.bean.ShopAddress;

import java.util.List;

public interface ShopAddressMapper {
     List<ShopAddress> getAddressList(String userId);
}
