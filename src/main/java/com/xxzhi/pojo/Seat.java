package com.xxzhi.pojo;

import com.alibaba.fastjson.JSONObject;

/**
 * 座位号实体
 * @author temuulen
 * @value seatId 座位编号
 * @value floor 楼层数
 * @value num   座位编号
 * @value status 预约状态 有预约->0,未预约->1;
 * @value endTime 结束时间
 * @value readerId 读者Id
 */
public class Seat {
    private String seatId;
    private int floor;
    private int num;
    private int status;
    private String endTime;
    private String readerId;
    public Seat() {
    }

    public Seat(String seatId, int floor, int num) {
        this.seatId = seatId;
        this.floor = floor;
        this.num = num;
    }

    public Seat(String seatId, int floor, int num, int status, String endTime, String readerId) {
        this.seatId = seatId;
        this.floor = floor;
        this.num = num;
        this.status = status;
        this.endTime=endTime;
        this.readerId=readerId;
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
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
