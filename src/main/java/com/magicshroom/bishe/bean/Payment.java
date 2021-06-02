package com.magicshroom.bishe.bean;

import lombok.Data;

@Data
public class Payment {
    private String payTradeNo;
    private String payAmount;
    private String payUserId;
    private String payOutTradeNo;
}
