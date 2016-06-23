package com.demo.model;

public class UserModel {
    private String name;
    private String passwd;

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPasswd(String passwd){
        this.passwd = passwd;
    }

    public String getPasswd() {
        return this.passwd;
    }
}