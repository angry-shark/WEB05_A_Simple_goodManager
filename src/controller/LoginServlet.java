package controller;

import model.User;
import service.Userserivce;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login_do")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Userserivce userserivce = new Userserivce();
        User user = userserivce.login(username,password);
        if (user != null){
            request.getSession().setAttribute("user",user);
            //TODO
           if (user.isAdmin()){
               //TODO
               //response.sendRedirect(request.getContextPath()+ "/admin/good_lists.jsp");
               //将请求转发到GoodListServlet
               //request.getRequestDispatcher("/admin/good_lists").forward(request,response);
               response.sendRedirect(request.getContextPath()+ "/admin/good_lists");
           }else{
               request.getRequestDispatcher("/index.jsp").forward(request,response);
           }
        }else{
            request.setAttribute("message","<font color='red'>账号或密码错误，请重试！<font/>");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }
}
