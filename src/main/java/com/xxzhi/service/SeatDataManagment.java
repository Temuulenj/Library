package com.xxzhi.service;

import com.alibaba.fastjson.JSONObject;
import com.xxzhi.dao.SeatDao;
import com.xxzhi.pojo.Seat;

import java.util.ArrayList;

/**
 * 座位信息管理
 * @author temuulen
 */
public class SeatDataManagment {
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

}