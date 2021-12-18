package com.xxzhi.pojo;

import com.alibaba.fastjson.JSONObject;

/**
 * 读者实体
 * @author temuulen
 */
public class Reader {
    private String readerId;
    private String password;
    private String name;
    private String email;

    public Reader() {
    }

    public Reader(String readerId, String password, String name, String email) {
        this.readerId = readerId;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return JSONObject.toJSONString(this,true);
    }
}
