package controller;

import service.Userserivce;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register_do")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int age = Integer.parseInt(request.getParameter("age"));
        String sex = request.getParameter("sex");

        //通过UserService来进行注册
        Userserivce userserivce = new Userserivce();
        boolean isSuccss = userserivce.register(username,password,age,sex);
        if (isSuccss){
            request.setAttribute("message","<font color='green'>注册成功，请登陆</font>");
            //注册成功，跳转至login.jsp(通过请求转发)
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }else{
            request.setAttribute("message","<font color='red'>注册失败，请重新注册</font>");
            //注册失败，回到注册界面
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
    }
}
