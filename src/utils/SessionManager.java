package utils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class SessionManager {

    public static Map<String, HttpSession> sessionMap = new HashMap<String, HttpSession>();

    public static void test(String name,HttpSession session){
        System.out.println("add");
        sessionMap.put(name, session);
    }

}
