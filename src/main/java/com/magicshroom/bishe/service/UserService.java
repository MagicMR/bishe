package com.magicshroom.bishe.service;

import com.magicshroom.bishe.bean.User;

import java.util.Map;

public interface UserService {
    User getUserByPhone(String phone);

    Map<String, Object> register(String phone,String password);
}
