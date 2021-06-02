package com.magicshroom.bishe.bean;

import lombok.Data;

@Data
public class User {
    private Integer userId;
    private String userName;
    private String phone;
    private String password;
    private String email;
}
