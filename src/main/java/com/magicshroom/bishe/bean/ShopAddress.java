package com.magicshroom.bishe.bean;

import lombok.Data;

@Data
public class ShopAddress {
    private Integer addressId;
    private Integer userId;
    private String name;
    private String province;
    private String city;
    private String country;
    private String address;
    private String phone;
}
