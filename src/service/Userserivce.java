package service;

import dao.UserDao;
import model.User;

import java.util.UUID;

public class Userserivce {
    public boolean register(String _username,String _password,int _age,String _sex){
        UserDao userDao = new UserDao();
        boolean isExist = userDao.isExist(_username);
        if (isExist){
            //账号已经存在，注册失败
            return false;
        }else{
            userDao.addUser(_username,_password,_age,_sex);
            return true;
        }
    }

    public User login(String _username, String _password){
        UserDao userDao = new UserDao();
        return userDao.getUserByUsernameAndPassword(_username,_password);
    }
}
