package com.xxzhi.pojo;

import com.alibaba.fastjson.JSONObject;

/**
 * 预约记录实体
 * @author xxzhi
 */
public class ReserveInfo {
    private String infoId;
    private String time;
    private String readerId;
    private String seatId;
    private String startTime;
    private String endTime;
    private int type;
    public ReserveInfo() {
    }

    public ReserveInfo(String readerId, String seatId, String startTime, String endTime) {
        this.readerId = readerId;
        this.seatId = seatId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public ReserveInfo(String readerId, String seatId, int type) {
        this.readerId = readerId;
        this.seatId = seatId;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ReserveInfo(String readerId, String seatId, String startTime, String endTime, int type) {
        this.readerId = readerId;
        this.seatId = seatId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
    }

    public ReserveInfo(String infoId, String time, String readerId, String seatId, String startTime, String endTime) {
        this.infoId = infoId;
        this.time = time;
        this.readerId = readerId;
        this.seatId = seatId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    @Override
    public String toString(){
        return JSONObject.toJSONString(this,true);
    }
}
