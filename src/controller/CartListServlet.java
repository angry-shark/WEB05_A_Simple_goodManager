package controller;

import model.*;
import service.BankService;
import service.CartService;
import service.Userserivce;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@WebServlet("/CartList")
public class CartListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        CartService cartService = new CartService();
        BankService bankService = new BankService();
        ArrayList<Good> cartList = cartService.getPersonCart(user.getCustomerid());
        Map<Integer,Integer> cartlistCount = cartService.getPersinCartCount(user.getCustomerid());
        ArrayList<CartItem> showlist = new ArrayList<>();
        ArrayList<BankAccount> bankList = bankService.getPersonBankAccount(user.getCustomerid());
        int sum = 0;
        for (int i = 0; i < cartList.size(); i++) {
            Good temp = cartList.get(i);
            showlist.add(new CartItem(temp.getItemName(),temp.getPrice(),cartlistCount.get(temp.getItemid()),temp.getItemid()));
            sum += (temp.getPrice() * cartlistCount.get(temp.getItemid()));
        }
        request.setAttribute("BankList",bankList);
        request.getSession().setAttribute("SumPrice",sum);
        request.getSession().setAttribute("showList",showlist);
        request.getRequestDispatcher("/cart.jsp").forward(request,response);
    }
}
