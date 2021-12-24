package com.xxzhi.pojo;

/**
 * @author temuulen
 */
public class SignInfo {
    private String signId;
    private String readerId;
    private String signTime;
    private int signType;
    private String seatId;

    public SignInfo() {
    }

    public SignInfo(String readerId, String seatId,int signType) {
        this.readerId = readerId;
        this.signType = signType;
        this.seatId = seatId;
    }

    public SignInfo(String signId, String readerId, String signTime, int signType, String seatId) {
        this.signId = signId;
        this.readerId = readerId;
        this.signTime = signTime;
        this.signType = signType;
        this.seatId = seatId;
    }

    public int getSignType() {
        return signType;
    }

    public void setSignType(int signType) {
        this.signType = signType;
    }

    public String getSignId() {
        return signId;
    }

    public void setSignId(String signId) {
        this.signId = signId;
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime;
    }


    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }
}
