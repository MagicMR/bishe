package com.magicshroom.bishe.controller;

import com.magicshroom.bishe.bean.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/test")
    public User tets1(){
        User user=new User();
        user.setPhone("adsad");
        return user;
    }
}
