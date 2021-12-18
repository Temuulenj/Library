package com.xxzhi.service;

import com.alibaba.fastjson.JSONObject;
import com.xxzhi.dao.SeatDao;
import com.xxzhi.pojo.FloorSeat;
import com.xxzhi.pojo.Seat;
import com.xxzhi.pojo.SeatsInfo;

import java.util.ArrayList;

/**
 * 座位信息管理
 * @author temuulen
 */
public class SeatService {
    /**
     * 添加座位
     * @author temuulen
     * @param seat 座位
     * @return 是否成功
     */
    public String add(Seat seat){
        String msg;
        if(SeatDao.selectOne(seat.getSeatId())!=null){
            msg="此座位已存在";
            return msg;
        }
        if(SeatDao.insert(seat)){
            msg="success";
        }else {
            msg="error";
        }
        return msg;
    }

    /**
     * 获取全部座位信息
     *
     */
    public String getAll(){
        ArrayList<Seat> list=SeatDao.selectAll();
        return JSONObject.toJSONString(list);
    }

    /**
     * 按楼层获取座位信息
     * @param floor 目标楼层
     * @return 座位信息
     */
    public String getByFloor(int floor,int status){
        ArrayList<Seat>floorSeat=SeatDao.selectReservable(floor,status);
        return JSONObject.toJSONString(floorSeat);
    }
    /**
     *
     * @return 返回所有楼层的可用座位数和已预约座位数
     */
    public String getAllInfo() {
        ArrayList<SeatsInfo> infos = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int oldInfo = SeatDao.getInfoByFloor(i+1);
            SeatsInfo si =new SeatsInfo(i,oldInfo/100%100,oldInfo % 100);
            infos.add(si);
        }
        return JSONObject.toJSONString(infos);
    }
}