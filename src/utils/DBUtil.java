package utils;

import model.BankAccount;
import model.Cart;
import model.Good;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtil {
    public static Map<String, User> userMap = new HashMap<String, User>();
    public static List<Good> goodList = new ArrayList<Good>();
    public static Map<String,ArrayList<Good>> CartData = new HashMap<>();
    public static Map<String,ArrayList<BankAccount>> BankData = new HashMap<>();
    public static Map<String,ArrayList<Cart>> CartDataTwo = new HashMap<>();

    private static Connection conn;

    static {
        conn = getConnection();
        initAllData();
        updateAllData();
    }

    //通用方法
    public static void initAllData(){
        userMap = null;
        goodList = null;
        CartData = null;
        BankData = null;
        CartDataTwo = null;
    }
    public static void updateAllData(){
        userMap = new HashMap<String, User>();
        goodList = new ArrayList<Good>();
        CartData = new HashMap<>();
        BankData = new HashMap<>();
        CartDataTwo = new HashMap<>();

        getAllUser();
        getAllItem();
        getAllCart();
        getAllbankCount();
    }
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/dbappdev?useUnicode=true&useSSL=true&serverTimezone=UTC";
        String username="root";
        String password="root";
        Connection temp = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            temp = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    //modify User
    private static void getAllUser(){
        String sql = "SELECT * from user";
        PreparedStatement preparedStatement;
        try{
            preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
               User user = new User(rs.getString("customerid"),
                       rs.getString("userid"),rs.getString("password"));
               userMap.put(user.getCustomerid(),user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static User getUser(String customerid){
        if(userMap.containsKey(customerid)){
            return userMap.get(customerid);
        }else{
            return null;
        }
    }
    public static int addUser(User _user) throws SQLException {
        if(userMap.containsKey(_user.getCustomerid())){
            return 0;
        }else {
            String sql = "INSERT into user values (?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,_user.getCustomerid());
            preparedStatement.setString(2,_user.getUserid());
            preparedStatement.setString(3,_user.getPassword());
            int i = preparedStatement.executeUpdate();
            initAllData();
            updateAllData();
            System.out.println("Success");
            return i;
        }
    }

    //modify cart and good
    private static void getAllItem(){
        String sql = "SELECT * from item";
        PreparedStatement preparedStatement;
        try{
            preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Good item = new Good(Integer.parseInt(rs.getString("price")),
                        Integer.parseInt(rs.getString("itemid")),rs.getString("itemName"));
                goodList.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static ArrayList<Good> getGoodNamesbyIds(ArrayList<Cart> ids){
        ArrayList<Good> temp = new ArrayList<>();
        for (int i = 0; i < ids.size(); i++) {
            for (int j = 0; j < goodList.size() ; j++) {
                if(ids.get(i).getItemid() == goodList.get(j).getItemid()){
                    temp.add(goodList.get(j));
                }
            }
        }
        return temp;
    }
    public static void getAllCart(){
        for (String key: userMap.keySet()) {
            getOneCartFromDB(key);
        }
    }
    private static void getOneCartFromDB(String Customerid){
        ArrayList<Cart> temps = new ArrayList<>();
        String sql = "SELECT * from cart where customerid = (?)";
        PreparedStatement preparedStatement;
        try{
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,Customerid);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Cart item = new Cart(Integer.parseInt(rs.getString("itemid")),
                        rs.getString("customerid"),Integer.parseInt(rs.getString("itemcount")));
                temps.add(item);
            }
            CartData.put(Customerid,getGoodNamesbyIds(temps));
            CartDataTwo.put(Customerid,temps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static int changeCart(String Customerid,int itemid,int itemCount) throws SQLException {
            String sql = "INSERT into cart values (?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,Customerid);
            preparedStatement.setInt(2,itemid);
            preparedStatement.setInt(3,itemCount);
            int i = preparedStatement.executeUpdate();
            initAllData();
            updateAllData();
            System.out.println("Success");
            return i;
    }
    public static int updateCart(String Customerid,int itemid,int itemCount) throws SQLException {
        String sql = "UPDATE cart set itemcount = ? where customerid = ? and itemid = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,itemCount);
        preparedStatement.setString(2,Customerid);
        preparedStatement.setInt(3,itemid);
        int i = preparedStatement.executeUpdate();
        initAllData();
        updateAllData();
        System.out.println("Success");
        return i;
    }
    public static int removeCart(String Customerid,int itemid) throws SQLException {
        String sql = "DELETE from cart where customerid = ? and itemid =?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,Customerid);
        preparedStatement.setInt(2,itemid);
        int i = preparedStatement.executeUpdate();
        initAllData();
        updateAllData();
        String result = i == 1?"Success":"fail";
        System.out.println(result);
        return i;
    }
    public static int buyItem(int itemid,String customerid) throws SQLException {
        initAllData();
        updateAllData();
        if(CartDataTwo.containsKey(customerid)){
            ArrayList<Cart> temp = CartDataTwo.get(customerid);
            for (int i = 0; i < temp.size(); i++) {
                if(temp.get(i).getItemid() == itemid){
                    return updateCart(customerid,itemid,temp.get(i).getItemcount() + 1);
                }
            }
            return changeCart(customerid,itemid,1);
        }else{
            return changeCart(customerid,itemid,1);
        }
    }
    public static int changeItemCount(int itemid,String customeid,int count) throws SQLException {
        ArrayList<Cart> temp = CartDataTwo.get(customeid);
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).getItemid() == itemid) {
                if(temp.get(i).getItemcount()+count <= 0) {
                    return removeCart(customeid, itemid);
                }else{
                    return updateCart(customeid,itemid,temp.get(i).getItemcount() + count);
                }
            }
        }
        return -1;
    }
    public static int resetCart(String Customerid) throws SQLException {
        String sql = "DELETE from cart where customerid = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,Customerid);
        int i = preparedStatement.executeUpdate();
        initAllData();
        updateAllData();
        System.out.println("result is: " + (i != 0));
        return i;
    }

    //modify Bank
    private static void getAllbankCount(){
        for (String key:userMap.keySet()) {
            getOneBankCount(key);
        }
    }
    private static void getOneBankCount(String Customerid){
        ArrayList<BankAccount> temps = new ArrayList<>();
        String sql = "SELECT * from bankaccount where customerid = (?)";
        PreparedStatement preparedStatement;
        try{
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,Customerid);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                BankAccount item = new BankAccount(Customerid,Integer.parseInt(rs.getString("accountid")));
                temps.add(item);
            }
            BankData.put(Customerid,temps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static int addBankAccount(String Customerid,int BankAccount) throws SQLException {
        ArrayList<BankAccount> templist = BankData.get(Customerid);
        if(templist != null){
            for (int i = 0; i < templist.size(); i++) {
                if(templist.get(i).getAccountid() == BankAccount){
                    System.out.println("Account is exist");
                    return -1;
                }
            }
        }
        String sql = "INSERT into bankaccount values (?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,Customerid);
        preparedStatement.setInt(2,BankAccount);
        int i = preparedStatement.executeUpdate();
        initAllData();
        updateAllData();
        String result = i == 1?"Success":"fail";
        System.out.println(result);
        return i;
    }
    public static int removeAccount(String Customerid,int BankAccount) throws SQLException {
        String sql = "DELETE from bankaccount where customerid =  ? and accountid = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,Customerid);
        preparedStatement.setInt(2,BankAccount);
        int i = preparedStatement.executeUpdate();
        initAllData();
        updateAllData();
        String result = i == 1?"Success":"fail";
        System.out.println(result);
        return i;
    }


}
