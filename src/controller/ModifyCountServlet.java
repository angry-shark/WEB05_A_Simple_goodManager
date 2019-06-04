package controller;

import model.BankAccount;
import model.Cart;
import model.CartItem;
import model.User;
import service.BankService;
import service.CartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/changeCount")
public class ModifyCountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isSuccess = false;
        int itemid = Integer.parseInt(request.getParameter("itemid"));
        User user = (User) request.getSession().getAttribute("user");
        int count = Integer.parseInt(request.getParameter("itemcount"));
        CartService cartService = new CartService();
        try {
            isSuccess = cartService.changeCount(itemid,user.getCustomerid(),count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList<CartItem> showlist = (ArrayList<CartItem>) request.getSession().getAttribute("showList");
        int sum = 0;
        for (int i = 0; i < showlist.size(); i++) {
            sum += (showlist.get(i).getItemCount() * showlist.get(i).getPrice());
        }
        request.getSession().setAttribute("SumPrice",sum);
        response.getWriter().append("{\"isSuccess\":" + isSuccess + "}");
    }
}
