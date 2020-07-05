package com.atguigu.test;

import com.atguigu.dao.OrderDao;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Author: jiang
 * @Date: 7/3/2020
 * Description: TODO
 */
public class OrderDaoTest {

    @Test
    public void saveOrder(){
        OrderDao orderDay = new OrderDaoImpl();
        orderDay.saveOrder(new Order("123456",new Date(),new BigDecimal(100),0,1));
    }

}