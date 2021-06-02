package com.magicshroom.bishe.service.impl;

import com.magicshroom.bishe.bean.User;
import com.magicshroom.bishe.mapper.UserMapper;
import com.magicshroom.bishe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper mapper;

    @Override
    public User getUserByPhone(String phone) {
        return mapper.getUserByPhone(phone);
    }

    @Override
    public Map<String, Object> register(String phone,String password) {
        Map<String, Object> map = new HashMap<>();
        User user = getUserByPhone(phone);
        if (user!=null){
            map.put("msg","该手机号已注册，请登录！！");
            map.put("success",false);
            return map;
        }
        mapper.insertUser(phone,password);
        map.put("msg","注册成功");
        map.put("success",true);
        return map;
    }
}
