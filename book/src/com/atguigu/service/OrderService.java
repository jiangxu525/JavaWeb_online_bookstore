package com.atguigu.service;

import com.atguigu.pojo.Cart;

/**
 * @Author: jiang
 * @Date: 7/3/2020
 * Description: TODO
 */
public interface OrderService {
    public String createOrder(Cart cart, Integer userId);
}
