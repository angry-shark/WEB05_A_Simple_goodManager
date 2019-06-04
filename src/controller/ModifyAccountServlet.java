package controller;

import model.User;
import service.BankService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/changeAccount")
public class ModifyAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        int Accountid = Integer.parseInt(request.getParameter("accountid"));
        int operation = Integer.parseInt(request.getParameter("operation"));//区分add（1） and remove（0）
        System.out.println("op is: " + operation);
        BankService bankService = new BankService();
        boolean result = false;
        if(operation == 1){
            try {
                result = bankService.addBankAccount(Accountid,user.getCustomerid());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            try {
                result = bankService.removeBankAccount(user.getCustomerid(),Accountid);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        response.getWriter().append("{\"isSuccess\":" + result + "}");

    }
}
