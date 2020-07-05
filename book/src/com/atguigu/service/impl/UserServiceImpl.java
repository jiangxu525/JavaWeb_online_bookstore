package com.atguigu.service.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;

/**
 * @Author: jiang
 * @Date: 6/4/2020
 * Description: This is the implementation of UserService
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registerUser(User user) {
    userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String name) {
    if(userDao.queryUserByUsername(name) == null){
        return false;
    }
    return true;
    }
}
