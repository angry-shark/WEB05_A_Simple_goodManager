package service;


import dao.CartDao;
import model.Good;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class CartService {
    CartDao cartDao = new CartDao();
    public ArrayList<Good> getPersonCart(String customerid){
        return cartDao.getUserCart(customerid);
    }

    public Map<Integer,Integer> getPersinCartCount(String customerid){
        return cartDao.getAllCartCount(customerid);
    }

    public boolean buyItem(int itemid,String customerid) throws SQLException {
        return cartDao.buyItem(itemid,customerid);
    }

    public boolean changeCount(int itemid,String customerid,int count) throws SQLException {
        return cartDao.modifyItemCount(itemid,customerid,count);
    }

    public boolean resetCart(String customerid) throws SQLException {
        return cartDao.resetCart(customerid);
    }
}
