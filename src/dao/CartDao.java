package dao;

import model.Cart;
import model.Good;
import utils.DBUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CartDao {
    public ArrayList<Good> getUserCart(String customerid){
        ArrayList<Good> result = null;
        for (String key:DBUtil.CartData.keySet()) {
            if(key.equals(customerid)){
                result = DBUtil.CartData.get(customerid);
            }
        }
        return result;
    }

    public Map<Integer,Integer> getAllCartCount(String customerid){
        ArrayList<Cart> allCarts = DBUtil.CartDataTwo.get(customerid);
        Map<Integer,Integer> result = new HashMap<>();
        for (int i = 0; i < allCarts.size(); i++) {
            result.put(allCarts.get(i).getItemid(),allCarts.get(i).getItemcount());
        }
        return result;
    }

    public boolean buyItem(int itemid,String customerid) throws SQLException {
        int i = DBUtil.buyItem(itemid,customerid);
        return (i == 1);
    }

    public boolean modifyItemCount(int itemid,String customerid,int count) throws SQLException {
        int i = DBUtil.changeItemCount(itemid,customerid,count);
        return  (i==1);
    }

    public boolean resetCart(String Customerid) throws SQLException {
        int i = DBUtil.resetCart(Customerid);
        return (i != 0);
    }
}
