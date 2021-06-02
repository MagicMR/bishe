package com.magicshroom.bishe.mapper;

import com.magicshroom.bishe.bean.User;

public interface UserMapper {

    public User getUserByPhone(String phone);

    public void insertUser(String phone,String password);

}
