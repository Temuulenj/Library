package com.xxzhi.pojo;

import com.alibaba.fastjson.JSONObject;

/**
 * 座位号实体
 * @author temuulen
 */
public class Seat {
    private String seatId;
    private int floor;
    private int num;
    private int status;

    public Seat() {
    }

    public Seat(String seatId, int floor, int num, int status) {
        this.seatId = seatId;
        this.floor = floor;
        this.num = num;
        this.status = status;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return JSONObject.toJSONString(this,true);
    }
}
