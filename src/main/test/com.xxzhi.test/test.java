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

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class test {
    @Test
    public void daoTest(){
        System.out.println(new ReserveService().cancelReserve("123"));
    }
    @Test
    public void insertData(){
        for (int i=1;i<=20;i++){
            for (int j=1;j<=20;j++){
                int id=i*100+j;
                System.out.println(id+" "+SeatDao.insert(new Seat(String.valueOf(id),i,j)));
            }
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
        //System.out.println(ReaderDao.selectOne("123"));
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(date));
    }
}