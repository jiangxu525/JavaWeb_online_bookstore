package com.atguigu.test;

import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Author: jiang
 * @Date: 7/3/2020
 * Description: TODO
 */
public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(null,"ssfsdffd",1,new BigDecimal(100),new BigDecimal(100),"123456"));
    }
}