package com.xxzhi.service;

import com.xxzhi.dao.ReaderDao;
import com.xxzhi.dao.ReserveInfoDao;
import com.xxzhi.dao.SeatDao;
import com.xxzhi.pojo.Reader;
import com.xxzhi.pojo.ReserveInfo;
import com.xxzhi.pojo.Seat;

/**
 * @author temuulen
 */
public class ReserveService {
    public String reserve(String readerId,String seatId){
        String msg;
        String startTime="2021-11-11 00:00:00";
        String endTime="2021-11-12 00:00:00";
        Reader reader=ReaderDao.selectOne(readerId);
        Seat seat= SeatDao.selectOne(seatId);
        ReserveInfo reserveInfo=new ReserveInfo(readerId, seatId, startTime, endTime,1);
        if (reader==null){
            return msg="此账号不存在";
        }
        if (seat==null){
            return msg="此座位不存在";
        }
        if (reader.getReserveStatus()!=1){
            return msg="该账号已预约"+reader.getSeatId()+"座位";
        }
        if (seat.getStatus()!=1){
            return msg="该座位已有人预约、于"+seat.getEndTime()+"结束";
        }
        if (reserveInfo==null){
            return msg="预约记录不存在";
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
                    return msg="ReserveInfo写入失败！";
                }

            }
            else {
                return msg="reader更新失败！";
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
            return msg="尝试修复";
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