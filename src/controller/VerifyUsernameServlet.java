package controller;

import service.Userserivce;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/verifyusername")
public class VerifyUsernameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        Userserivce userserivce = new Userserivce();
        boolean isExist = userserivce.isExist(username);

        //response中传入json样式的String
        response.getWriter().append("{\"isSuccess\":" + !isExist + "}");

    }

}
