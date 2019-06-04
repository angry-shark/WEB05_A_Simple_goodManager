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

@WebServlet("/buyitem")
public class BuyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isSuccess = false;
        int itemid = Integer.parseInt(request.getParameter("itemid"));
        User user = (User) request.getSession().getAttribute("user");
        System.out.println("itemid is: " + itemid + "User is: " + user.getCustomerid());
        CartService cartService = new CartService();
        try {
            isSuccess = cartService.buyItem(itemid,user.getCustomerid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.getWriter().append("{\"isSuccess\":" + isSuccess + "}");
    }
}
