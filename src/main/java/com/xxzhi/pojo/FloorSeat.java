package com.xxzhi.pojo;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

/**
 * @author temuulen
 * @value floor 楼层数
 * @value seats 预约状态
 */
public class FloorSeat {
    private int floor;
    private ArrayList<Seat> seats;

    public FloorSeat() {
    }

    public FloorSeat(int floor, ArrayList<Seat> seats) {
        this.floor = floor;
        this.seats = seats;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }

    @Override
    public String toString(){
        return JSONObject.toJSONString(this,true);
    }

}
