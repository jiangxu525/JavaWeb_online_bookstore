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
 * @Date: 6/4/2020
 * Description: TODO
 */
public class RegistServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        if("abcde".equalsIgnoreCase(code)){

            if(userService.existsUsername(username)){
                req.setAttribute("msg","User name already exists.");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);

            }else{
                userService.registerUser(new User(null,username,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }
        }else{
            req.setAttribute("msg","Wrong verification code!");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);

        }


    }
}
