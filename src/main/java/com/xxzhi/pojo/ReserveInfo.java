package com.xxzhi.pojo;

import com.alibaba.fastjson.JSONObject;

/**
 * 预约记录实体
 * @author xxzhi
 */
public class ReserveInfo {
    private String reserveId;
    private String reserveTime;
    private String readerId;
    private String seatId;
    private String startTime;
    private String endTime;
    private int reserveType;
    public ReserveInfo() {
    }

    public ReserveInfo(String readerId, String seatId, String startTime, String endTime, int reserveType) {
        this.readerId = readerId;
        this.seatId = seatId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.reserveType = reserveType;
    }

    public ReserveInfo(String readerId, String seatId, int reserveType) {
        this.readerId = readerId;
        this.seatId = seatId;
        this.reserveType = reserveType;
    }

    public ReserveInfo(String reserveId, String reserveTime, String readerId, String seatId, String startTime, String endTime, int reserveType) {
        this.reserveId = reserveId;
        this.reserveTime = reserveTime;
        this.readerId = readerId;
        this.seatId = seatId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.reserveType = reserveType;
    }

    public String getReserveId() {
        return reserveId;
    }

    public void setReserveId(String reserveId) {
        this.reserveId = reserveId;
    }

    public String getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(String reserveTime) {
        this.reserveTime = reserveTime;
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getReserveType() {
        return reserveType;
    }

    public void setReserveType(int reserveType) {
        this.reserveType = reserveType;
    }

    @Override
    public String toString(){
        return JSONObject.toJSONString(this,true);
    }
}
