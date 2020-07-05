package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Author: jiang
 * @Date: 7/2/2020
 * Description: TODO
 */
public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "dfsf", 1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "435345", 1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(3, "sdfsdfgdg", 1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(4, "eeee", 1,new BigDecimal(100),new BigDecimal(100)));

        System.out.println(cart);
    }

    @Test
    public void deleteItem() {

        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "dfsf", 1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "435345", 1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(3, "sdfsdfgdg", 1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(4, "eeee", 1,new BigDecimal(100),new BigDecimal(100)));
        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "dfsf", 1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "435345", 1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(3, "sdfsdfgdg", 1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(4, "eeee", 1,new BigDecimal(100),new BigDecimal(100)));
        cart.deleteItem(1);
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "dfsf", 1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "435345", 1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(3, "sdfsdfgdg", 1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(4, "eeee", 1,new BigDecimal(100),new BigDecimal(100)));
        cart.updateCount(1, 10);
        System.out.println(cart);
    }
}