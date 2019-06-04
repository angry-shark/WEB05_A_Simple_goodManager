package service;

import dao.BankDao;
import model.BankAccount;

import java.sql.SQLException;
import java.util.ArrayList;

public class BankService {
    BankDao bankDao = new BankDao();
    public ArrayList<BankAccount> getPersonBankAccount(String customerid){
        return bankDao.getUserBank(customerid);
    }

    public boolean addBankAccount(int BankAccountid,String Customerid) throws SQLException {
        int i = bankDao.addUserBank(Customerid,BankAccountid);
        return (i != 0 && i != -1);
    }

    public Boolean removeBankAccount(String Customerid,int BankAccountid) throws SQLException {
        boolean result = bankDao.removeUserBank(Customerid,BankAccountid);
        return result;
    }
}
