package com.atguigu.web;

import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: jiang
 * @Date: 6/6/2020
 * Description: TODO
 */
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");


        User loginUser = userService.login(new User(null, username, password, null));
        if(loginUser==null){
            req.setAttribute("msg","Invalid username or password");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }

    }
}
