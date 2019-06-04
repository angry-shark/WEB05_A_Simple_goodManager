package service;

import dao.UserDao;
import model.User;

import java.sql.SQLException;
import java.util.UUID;

public class Userserivce {

//    public static void main(String[] args) throws SQLException {
//        Userserivce us = new Userserivce();
//        us.register("bbbbbbb","bbbbbbb","bbbbbbbb");
//    }


    public boolean register(String _customerid,String _username,String _password) throws SQLException {
        UserDao userDao = new UserDao();
        boolean isExist = userDao.isExist(_username);
        if (isExist){
            //账号已经存在，注册失败
            return false;
        }else{
            return userDao.addUser(_customerid,_username,_password);
        }
    }

    public User login(String _customerid,String _username, String _password){
        UserDao userDao = new UserDao();
        return userDao.getUserByUsernameAndPassword(_customerid,_username,_password);
    }

    public boolean isExist(String _username){
        return new UserDao().isExist(_username);
    }
}
