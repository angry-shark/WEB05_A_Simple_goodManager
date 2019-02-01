package dao;

import model.User;
import utils.DBUtil;

public class UserDao {

    public boolean isExist(String _username){
        return DBUtil.userMap.containsKey(_username);
    }

    public boolean addUser(String _username,String _password,int _age,String _sex){
        if (isExist(_username)){
            return false;
        }else {
            User u = new User(_username,_password,_age,_sex,false);
            DBUtil.addUser(u);
            return true;
        }
    }

    public User getUserByUsernameAndPassword(String _username,String _password){
        if (!isExist(_username)){
            return null;
        }else{
            User temp = DBUtil.userMap.get(_username);
            if (temp.getPassword().equals(_password)){
                return temp;
            }else{
                return null;
            }
        }
    }
}
