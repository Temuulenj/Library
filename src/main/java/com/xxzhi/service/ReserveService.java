package com.xxzhi.service;

import com.xxzhi.dao.ReaderDao;
import com.xxzhi.dao.ReserveInfoDao;
import com.xxzhi.dao.SeatDao;
import com.xxzhi.pojo.Reader;
import com.xxzhi.pojo.ReserveInfo;
import com.xxzhi.pojo.Seat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author temuulen
 */
public class ReserveService {
    public String reserve(String readerId,String seatId,String startTime,String endTime){
        String msg;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        startTime=sdf.format(new Date())+" "+startTime+":00";
        endTime=sdf.format(new Date())+" "+endTime+":00";
        Reader reader=ReaderDao.selectOne(readerId);
        Seat seat= SeatDao.selectOne(seatId);
        ReserveInfo reserveInfo=new ReserveInfo(readerId, seatId, startTime, endTime,1);
        System.out.println(reserveInfo.toString());
        if (reader==null){
            return msg="Do not have this reader";
        }
        if (seat==null){
            return msg="Do not have this seat";
        }
        if (reader.getReserveStatus()!=1){
            return msg="this reader was reserved "+reader.getSeatId()+" seats";
        }
        if (seat.getStatus()!=1){
            return msg="The seat has been reserved、Ends At"+seat.getEndTime();
        }
        if (reserveInfo==null){
            return msg="ReserveInfo is null";
        }
        seat.setStatus(0);
        seat.setEndTime(endTime);
        seat.setReaderId(reader.getReaderId());
        reader.setSeatId(seat.getSeatId());
        reader.setReserveStatus(0);
        //ReserveInfoDao.insert(new ReserveInfo(readerId, seatId, startTime, endTime,1))
        if (SeatDao.updateOne(seat)){
            if (ReaderDao.updateOne(reader)){
                if (ReserveInfoDao.insert(reserveInfo)){
                    return msg="success";
                }
                else {
                    return msg="wrong with write reserveInfo！";
                }

            }
            else {
                return msg="wrong with reader updating";
            }
        }else {
            //尝试恢复
            seat.setStatus(1);
            seat.setEndTime(null);
            seat.setReaderId(null);
            reader.setSeatId(null);
            reader.setReserveStatus(1);
            SeatDao.updateOne(seat);
            ReaderDao.updateOne(reader);
            return msg="try to rollback";
        }
    }

    /**
     * 取消预约
     * @param readerId 读者ID
     * @return 结果
     */
    public String cancelReserve(String readerId){
        String msg;
        Reader reader=ReaderDao.selectOne(readerId);
        if (reader==null){
            return msg="该用户不存在";
        }
        else if (reader.getSeatId()==null){
            return msg="该用户未预约";
        }
        Seat seat=SeatDao.selectOne(reader.getSeatId());
        if(seat==null){
            return msg="未知错误：seatId不存在";
        }
        ReserveInfo reserveInfo=ReserveInfoDao.selectOne(readerId,reader.getSeatId());
        if (reserveInfo==null){
            return msg="未知错误：预约记录不存在";
        }
        seat.setStatus(1);
        seat.setEndTime(null);
        seat.setReaderId(null);
        reader.setSeatId(null);
        reader.setReserveStatus(1);
        SeatDao.updateOne(seat);
        ReaderDao.updateOne(reader);
        if(ReserveInfoDao.insert(new ReserveInfo(readerId, seat.getSeatId(), 0))){
            return msg="success";
        };
        return msg="未知错误";
    }
}