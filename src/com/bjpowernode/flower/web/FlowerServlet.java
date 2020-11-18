package com.bjpowernode.flower.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName FlowerServlet
 * @Description
 * @Author 付 尧
 * @Date 2020/10/29 23:29
 * @Version
 */
@WebServlet("/FlowerServlet")
public class FlowerServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        if ("flowerList".equals(type)){
            request.getRequestDispatcher("/").forward(request, response);
        }
    }
}
