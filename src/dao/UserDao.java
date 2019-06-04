package dao;

import model.User;
import utils.DBUtil;

import java.sql.SQLException;

public class UserDao {

    public boolean isExist(String _customerid){
        return DBUtil.userMap.containsKey(_customerid);
    }

    public boolean addUser(String _customerid,String _username,String _password) throws SQLException {
        DBUtil.updateAllData();
        if (isExist(_username)){
            return false;
        }else {
            User u = new User(_customerid,_username,_password);
            int i = DBUtil.addUser(u);
            System.out.println("i is: " + i);
            return (i==1);
        }
    }

    public User getUserByUsernameAndPassword(String _customerid,String _username,String _password){
        DBUtil.updateAllData();
        if (!isExist(_customerid)){
            System.out.println("isn't exist");
            return null;
        }else{
            User temp = DBUtil.userMap.get(_customerid);
            if (temp.getPassword().equals(_password) && temp.getUserid().equals(_username)){
                return temp;
            }else{
                System.out.println("password error");
                return null;
            }
        }
    }
}
