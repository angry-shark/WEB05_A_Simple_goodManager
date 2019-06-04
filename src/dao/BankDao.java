package dao;

import model.BankAccount;
import utils.DBUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class BankDao {
    public ArrayList<BankAccount> getUserBank(String customerid){
        ArrayList<BankAccount> result = null;
        for (String key: DBUtil.BankData.keySet()) {
            if(key.equals(customerid)){
                result = DBUtil.BankData.get(customerid);
            }
        }
        return result;
    }

    public boolean removeUserBank(String customerid,int accountid) throws SQLException {
       int i = DBUtil.removeAccount(customerid,accountid);
       return (i == 1);
    }

    public int addUserBank(String customerid,int accountid) throws SQLException {
        int i = DBUtil.addBankAccount(customerid,accountid);
        return i;
    }
}
