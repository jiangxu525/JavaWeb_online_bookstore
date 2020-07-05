package com.atguigu.web;

import com.alibaba.druid.util.JdbcUtils;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import com.atguigu.utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: jiang
 * @Date: 7/3/2020
 * Description: TODO
 */
@WebServlet(name = "OrderServlet", urlPatterns = {"/orderServlet"})
public class OrderServlet extends BaseServlet {

    private OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User loginUser = (User) req.getSession().getAttribute("user");

        if (loginUser == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }
        Integer userId = loginUser.getId();

        String orderId = orderService.createOrder(cart, userId);

        //  req.setAttribute("orderId", orderId);
        //  req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);
        req.getSession().setAttribute("orderId", orderId);
        resp.sendRedirect(req.getContextPath());

    }
}
