package com.atguigu.service;

/*
@author: 
@create
*/

import com.atguigu.pojo.User;

public interface UserService {


    public void registerUser(User user);


    public User login(User user);


    public boolean existsUsername(String name);


}
