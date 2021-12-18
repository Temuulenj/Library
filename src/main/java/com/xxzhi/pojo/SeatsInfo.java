package com.xxzhi.pojo;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

/**
 * @author temuulen
 */
public class SeatsInfo {
    private int floor;
    private int reserved;
    private int canReserve;

    public SeatsInfo() {
    }

    public SeatsInfo(int floor, int reserved, int canReserve) {
        this.floor = floor;
        this.reserved = reserved;
        this.canReserve = canReserve;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getReserved() {
        return reserved;
    }

    public void setReserved(int reserved) {
        this.reserved = reserved;
    }

    public int getCanReserve() {
        return canReserve;
    }

    public void setCanReserve(int canReserve) {
        this.canReserve = canReserve;
    }

    @Override
    public String toString(){
        return JSONObject.toJSONString(this,true);
    }
}