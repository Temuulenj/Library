package com.xxzhi.pojo;
import com.alibaba.fastjson.JSONObject;

/**
 * 违规记录实体
 * @author temuulen
 */
public class ViolationInfo {
    private String violationId;
    private String readerId;
    private String time;
    private int type;
    private String seatId;

    public ViolationInfo() {
    }

    public ViolationInfo(String readerId, int type, String seatId) {
        this.readerId = readerId;
        this.type = type;
        this.seatId = seatId;
    }

    public ViolationInfo(String violationId, String readerId, String time, int type, String seatId) {
        this.violationId = violationId;
        this.readerId = readerId;
        this.time = time;
        this.type = type;
        this.seatId = seatId;
    }

    public String getViolationId() {
        return violationId;
    }

    public void setViolationId(String violationId) {
        this.violationId = violationId;
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    @Override
    public String toString(){
        return JSONObject.toJSONString(this,true);
    }
}