package com.xxzhi.test;

import com.alibaba.fastjson.JSONObject;
import com.xxzhi.dao.ReaderDao;
import com.xxzhi.dao.SeatDao;
import com.xxzhi.dao.ViolationInfoDao;
import com.xxzhi.pojo.Seat;
import com.xxzhi.pojo.ViolationInfo;
import com.xxzhi.service.ReaderService;
import com.xxzhi.service.ReserveService;
import com.xxzhi.service.SeatService;
import com.xxzhi.servlet.GetSeatByFloor;
import org.junit.Test;

import java.util.ArrayList;

public class test {
    @Test
    public void daoTest(){

        //System.out.println(ViolationInfoDao.insert(new ViolationInfo("xxxzhi",123,"0716")));
        ArrayList<ViolationInfo> violationInfoList= ViolationInfoDao.selectAll();
        if (violationInfoList==null) {
            System.out.println(0);
            return;
        }
        for(ViolationInfo v:violationInfoList) {
            System.out.println(v.toString());
        }
    }



    /**
     * 测试服务
     */
    @Test
    public void serviceTest(){
//        String jsonString=new Seat("123",12,3,2).toString();
//        Seat seat= JSON.parseObject(jsonString,Seat.class);
//        System.out.println(seat.getFloor()+" "+seat.getStatus());
//        System.out.println(new SeatService().getByFloor(1));
//        System.out.println(new ReserveService().reserve("201916010606","101"));
        //System.out.println(new ReaderService().signIn("201916010606","024019"));
        System.out.println(ReaderDao.selectOne("201916010606"));
    }
}