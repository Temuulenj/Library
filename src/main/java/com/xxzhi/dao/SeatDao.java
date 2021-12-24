package com.xxzhi.dao;

import com.xxzhi.pojo.Seat;
import com.xxzhi.tools.ConnectMysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/** 对座位表的操作
 * @author xxzhi
 */
public class SeatDao {
    static PreparedStatement preStr;
    static ResultSet rs;

    /**
     * 插入一条座位信息
     * @param seat 座位
     * @return 是否成功
     */
    public static boolean insert(Seat seat){
        if (seat==null) {
            return false;
        }
        String sql="INSERT INTO library.seat(SEAT_ID, FLOOR, NUM, STATUS,END_TIME,READER_ID) VALUES (?,?,?,?,?,?)";
        try {
            Connection conn= new ConnectMysql().getConn();
            preStr=conn.prepareStatement(sql);
            preStr.setString(1, seat.getSeatId());
            preStr.setInt(2,seat.getFloor());
            preStr.setInt(3, seat.getNum());
            preStr.setInt(4, seat.getStatus());
            preStr.setString(5,seat.getEndTime());
            preStr.setString(6,seat.getReaderId());
            return preStr.executeUpdate()==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 根据seatId获取该座位的信息
     * @param seatId 座位号
     * @return 该座位的全部信息
     */
    public static Seat selectOne(String seatId){
        String sql="SELECT * FROM library.seat WHERE SEAT_ID=?";
        try {
            Connection conn= new ConnectMysql().getConn();
            preStr=conn.prepareStatement(sql);
            preStr.setString(1,seatId);
            rs =preStr.executeQuery();
            while (!rs.next()){
                return null;
            }
            return new Seat(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5), rs.getString(6));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取所有座位的信息
     * @return 所有座位信息
     */
    public static ArrayList<Seat> selectAll(){
        ArrayList<Seat> result = new ArrayList<>();
        String sql="SELECT * FROM library.seat";
        try {
            Connection conn= new ConnectMysql().getConn();
            preStr=conn.prepareStatement(sql);
            rs =preStr.executeQuery();
            while (rs.next()){
                result.add(new Seat(rs.getString(1), rs.getInt(2),
                        rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6)));
            }
            conn.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 更新一条座位信息
     * @param seat 座位
     * @return 是否成功
     */
    public static boolean updateOne(Seat seat){
        String sql="UPDATE library.seat SET STATUS=?,END_TIME=?,READER_ID=? WHERE SEAT_ID=?";
        Connection conn= new ConnectMysql().getConn();
        try {
            preStr=conn.prepareStatement(sql);
            preStr.setInt(1,seat.getStatus());
            preStr.setString(2,seat.getEndTime());
            preStr.setString(3,seat.getReaderId());
            preStr.setString(4,seat.getSeatId());
            return preStr.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 按楼层查询可预约1/不可预约/全部座位
     *
     */
    public static ArrayList<Seat> selectReservable(int floor,int status){
        ArrayList<Seat> list=new ArrayList<>();
        Connection conn= new ConnectMysql().getConn();
        if (status==3){
            String sql="SELECT * FROM library.seat WHERE FLOOR=?";
            try {
                preStr=conn.prepareStatement(sql);
                preStr.setInt(1,floor);
                rs=preStr.executeQuery();
                while (rs.next()){
                    list.add(new Seat(rs.getString(1), rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6) ));
                }
                return list;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if (status==1||status==0){
            String sql="SELECT * FROM library.seat WHERE FLOOR=? AND STATUS=?";
            try {
                preStr=conn.prepareStatement(sql);
                preStr.setInt(1,floor);
                preStr.setInt(2,status);
                rs=preStr.executeQuery();
                while (rs.next()){
                    list.add(new Seat(rs.getString(1), rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6) ));
                }
                return list;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 按楼层返回 已预约座位 空余座位 的数量
     * @return xxxx四位数字 前两位表示被预约的座位后两位表示空余座位
     */
    public static int getInfoByFloor(int floor){
        Connection conn= new ConnectMysql().getConn();
        int result=0;
        try {
            String sql="SELECT count(*) FROM library.seat WHERE FLOOR=? AND STATUS=0";
            preStr=conn.prepareStatement(sql);
            preStr.setInt(1,floor);
            rs=preStr.executeQuery();
            while (rs.next()){
                result+=rs.getInt(1);
            }
            result*=100;
            sql="SELECT count(*) FROM library.seat WHERE FLOOR=? AND STATUS=1";
            preStr=conn.prepareStatement(sql);
            preStr.setInt(1,floor);
            rs=preStr.executeQuery();
            if (rs==null){
                return -1;
            }
            while (rs.next()){
                result+=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}