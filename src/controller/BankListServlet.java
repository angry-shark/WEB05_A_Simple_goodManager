package controller;

import model.BankAccount;
import model.User;
import service.BankService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/BankList")
public class BankListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        BankService bankService = new BankService();
        ArrayList<BankAccount> BankList = bankService.getPersonBankAccount(user.getCustomerid());
        request.getSession().setAttribute("BankList",BankList);
        request.getRequestDispatcher("/addAccount.jsp").forward(request,response);
    }
}
