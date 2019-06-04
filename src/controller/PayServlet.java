package controller;

import model.User;
import service.CartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/pay")
public class PayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String accountid = request.getParameter("accountid");
        System.out.println("userid is: " + user.getCustomerid() + "\n Account id is: " + accountid);
        CartService cartService = new CartService();
        boolean isSuccess = false;
        try {
            isSuccess = cartService.resetCart(user.getCustomerid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.getWriter().append("{\"isSuccess\":" + isSuccess + "}");
    }
}
