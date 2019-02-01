package utils;

import model.User;

import java.util.HashMap;
import java.util.Map;

public class DBUtil {
    public static Map<String, User> userMap = new HashMap<String, User>();

    private static DBUtil instance;

    //静态代码块，当类被加载时会执行
    static {
        //添加管理员账号
        addUser(new User("root","root",10,"男",true));
    }

    public static void addUser(User _user){
        userMap.put(_user.getUsername(),_user);
    }


}
