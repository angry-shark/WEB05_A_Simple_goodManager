package model;

import com.alibaba.fastjson.JSON;

public class User {
    private String username;
    private String password;
    private int age;
    private String sex;

    public User(String username, String password, int age, String sex, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.isAdmin = isAdmin;
    }

    private boolean isAdmin = false;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }



}
