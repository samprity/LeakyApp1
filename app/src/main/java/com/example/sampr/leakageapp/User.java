package com.example.sampr.leakageapp;

/**
 * Created by sampr on 2017-02-01.
 */
public class User {
    public String uname;
    public String pwd;
    public User(String uname, String pwd) {
        this.uname = uname;
        this.pwd = pwd;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
