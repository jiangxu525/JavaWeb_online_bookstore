package com.atguigu.test;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/*
@author: 
@create
*/public class UserDaoTest {

    @Test
    public void queryUserByUsername() {
        UserDao userDao = new UserDaoImpl();

        System.out.println(userDao.queryUserByUsername("admin"));

    }

    @Test
    public void saveUser() {
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.saveUser(new User(null, "admindf", "123456", "xxxx@qq.com")));
    }

    @Test
    public void testQueryUserByUsername() {
        UserDao userDao = new UserDaoImpl();

        System.out.println(userDao.queryUserByUsernameAndPassword("admin","admin"));

    }
}