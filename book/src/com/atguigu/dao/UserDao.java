package com.atguigu.dao;/*
@author: 
@create
*/

import com.atguigu.pojo.User;
import org.junit.Test;

public interface UserDao {


    public User queryUserByUsername(String username);
    public int saveUser(User user);
    public User queryUserByUsernameAndPassword(String username, String password);
}
