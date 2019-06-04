package controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.mysql.cj.xdevapi.JsonArray;
import model.Good;
import model.User;
import service.Goodservice;
import service.Userserivce;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login_do")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerid = request.getParameter("customerid");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Userserivce userserivce = new Userserivce();
        User user = userserivce.login(customerid,username,password);
        if (user != null){
            request.getSession().setAttribute("user",user);
            List<Good> list = new Goodservice().selectAllGoods();
            request.setAttribute("list",list);
            System.out.println("name " + user.getUserid());
            System.out.println("goto panel");
            request.getRequestDispatcher("/UserPanel.jsp").forward(request,response);
        }else{
            System.out.println("error");
            request.setAttribute("message","<font color='red'>账号或密码错误，请重试！<font/>");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }
}
