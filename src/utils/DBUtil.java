package utils;

import model.Good;
import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtil {
    public static Map<String, User> userMap = new HashMap<String, User>();
    public static List<Good> goodList = new ArrayList<Good>();

    private static DBUtil instance;

    //静态代码块，当类被加载时会执行
    static {
        //添加管理员账号
        addUser(new User("root","root",10,"男",true));
        //商品列表初始化信息
        goodList.add(new Good("banana","China Banana",100,400));
        goodList.add(new Good("apple","China apple",100,400));
        goodList.add(new Good("orange","China orange",100,400));
        goodList.add(new Good("mango","China mango",100,400));
        goodList.add(new Good("pear","China pear",100,400));
    }

    public static void addUser(User _user){
        userMap.put(_user.getUsername(),_user);
    }


}
