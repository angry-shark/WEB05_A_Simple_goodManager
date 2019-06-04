package model;

import com.alibaba.fastjson.JSON;

public class User {
    private String userid;
    private String password;
    private String customerid;
    private boolean isAdmin;

    public User(String customerid,String username, String password) {
        this.userid = username;
        this.password = password;
        this.customerid = customerid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }
}
