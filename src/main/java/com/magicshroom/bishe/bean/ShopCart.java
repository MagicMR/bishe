package com.magicshroom.bishe.bean;

import lombok.Data;

@Data
public class ShopCart {
    private String productId;
    private String userId;
    private String selectColor;
    private String selectSpecification;
    private String productName;
    private Integer price;
    private String imgPath;
    private Integer number;
}
