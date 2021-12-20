package com.xxzhi.pojo;

import com.alibaba.fastjson.JSONObject;

/**
 * 读者实体
 * @author temuulen
 * @value readerId 读者编号
 * @value password 密码
 * @value name     读者姓名
 * @value email    读者邮箱
 * @value reserveStatus 是否预约  有预约->0,未预约->1;
 * @value seatId    预约的座位、允许为空
 */
public class Reader {
    private String readerId;
    private String name;
    private String password;
    private String email;
    private int reserveStatus;
    private String seatId;
    public Reader() {
    }

    public Reader(String readerId, String name, String password, String email, int reserveStatus, String seatId) {
        this.readerId = readerId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.reserveStatus = reserveStatus;
        this.seatId = seatId;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public int getReserveStatus() {
        return reserveStatus;
    }

    public void setReserveStatus(int reserveStatus) {
        this.reserveStatus = reserveStatus;
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
