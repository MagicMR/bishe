package com.magicshroom.bishe.controller;

import com.magicshroom.bishe.bean.User;
import com.magicshroom.bishe.service.UserService;
import com.magicshroom.bishe.utils.CheckCode;
import com.magicshroom.bishe.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RedisUtil redisUtil;

    @RequestMapping("/login01")
    public Map<String, Object> login(@RequestParam String phone,
                                     @RequestParam String password){
        User user = userService.getUserByPhone(phone);
        Map<String, Object> map = new HashMap<>();
        if (user==null){
            map.put("msg","该用户不存在！");
            map.put("user",null);
            return map;
        }else {
            if (!user.getPassword().equals(password)){
                map.put("msg","密码错误！！");
                map.put("user",null);
                return map;
            }
        }
        map.put("msg","登录成功！！");
        map.put("user",user);
        return map;
    }

    @RequestMapping("/login02")
    public Map<String, Object> login02(@RequestParam String phone,
                                     @RequestParam String checkCode){
        User user = userService.getUserByPhone(phone);
        Map<String, Object> map = new HashMap<>();
        if (user==null){
            map.put("msg","该用户不存在！");
            map.put("user",null);
            return map;
        }else {
            if (!redisUtil.get("checkCode").equals(checkCode)){
                map.put("msg","验证码错误！！");
                map.put("user",null);
                return map;
            }
        }
        map.put("msg","登录成功！！");
        map.put("user",user);
        return map;
    }

    @RequestMapping("/checkCode")
    public Map<String, Object> sendCheckCode(@RequestParam String phone){
        String checkCode = CheckCode.sendCheckCode(phone);
        redisUtil.set("checkCode",checkCode,300);
        Map<String, Object> map = new HashMap<>();
        map.put("msg","发送成功！！");
        return map;
    }

    @RequestMapping("/register")
    public Map<String, Object> register(@RequestParam String phone,
                                        @RequestParam String checkCode,
                                        @RequestParam String password){
        Map<String, Object> map = new HashMap<>();
        String correctCheckCode = (String) redisUtil.get("checkCode");
        if (!correctCheckCode.equals(checkCode)){
            map.put("msg","验证码错误");
            map.put("success",false);
            return map;
        }
        return userService.register(phone,password);
    }
}
