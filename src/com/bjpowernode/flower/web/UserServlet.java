package com.bjpowernode.flower.web;

import com.bjpowernode.flower.bean.User;
import com.bjpowernode.flower.service.UserService;
import com.bjpowernode.flower.service.impl.UserServiceImpl;
import com.bjpowernode.flower.util.BeanUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName UserServlet
 * @Description
 * @Author 付 尧
 * @Date 2020/10/29 23:32
 * @Version
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        if ("login".equals(type)){
            login(request,response);
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        User user = BeanUtil.formToBean(User.class, request.getParameterMap());
        user = userService.login(user);

        HttpSession session = request.getSession();
        if (user != null){
            session.setAttribute("user", user);
            request.getRequestDispatcher("/FlowerServlet?type=flowerList").forward(request, response);
        }
    }
}
