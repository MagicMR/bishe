package com.magicshroom.bishe.bean;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {
    private String productId;
    private String userId;
    private String selectColor;
    private String selectSpecification;
    private String productName;
    private Integer price;
    private String imgPath;
    private Integer number;
    private String payTradeNo;
    private String addressId;

}
