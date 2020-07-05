package com.atguigu.web;

import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @Author: jiang
 * @Date: 6/28/2020
 * Description: TODO
 */
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");


        User loginUser = userService.login(new User(null, username, password, null));
        if (loginUser == null) {
            req.setAttribute("msg", "Invalid username or password");
            req.setAttribute("username", username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            req.getSession().setAttribute("user", loginUser);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }

    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);

        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());


        if (token != null && token.equalsIgnoreCase(code)) {

            if (userService.existsUsername(username)) {
                req.setAttribute("msg", "User name already exists.");
                req.setAttribute("username", username);
                req.setAttribute("email", email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);

            } else {
                userService.registerUser(new User(null, username, password, email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("msg", "Wrong verification code!");
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }

    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        boolean existsUsername = userService.existsUsername(username);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("existsUsername",existsUsername);
        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        System.out.println(json);
        resp.getWriter().write(json);
    }
}
