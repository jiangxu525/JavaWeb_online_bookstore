package com.atguigu.test;

import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import org.junit.Test;

/**
 * @Author: jiang
 * @Date: 6/4/2020
 * Description: Test...
 */
public class UserServiceTest {

    UserService userService = new UserServiceImpl();
    @Test
    public void registerUser() {
        userService.registerUser(new User(null,"bbj168","6666666","bbj163.163.com"));

    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"admin","admin","sdfsdfsdf@gmail.com")));
    }

    @Test
    public void existsUsername() {
        System.out.println(userService.existsUsername("admin"));
    }
}