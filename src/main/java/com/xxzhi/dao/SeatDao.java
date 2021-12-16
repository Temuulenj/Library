package com.xxzhi.dao;

import com.xxzhi.pojo.Reader;
import com.xxzhi.pojo.Seat;
import com.xxzhi.pojo.ViolationInfo;
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
    static Connection conn= ConnectMysql.getConn();
    static PreparedStatement preStr;
    static ResultSet rs;

    /**
     * 插入一条座位信息
     * @param seat 座位
     * @return 是否成功
     */
    static boolean inser(Seat seat){
        String sql="INSERT INTO SEAT(SEAT_ID, FLOOR, NUM, STATUS) VALUES (?,?,?,?)";
        try {
            preStr=conn.prepareStatement(sql);
            preStr.setString(1, seat.getSeatId());
            preStr.setInt(2,seat.getFloor());
            preStr.setInt(3, seat.getNum());
            preStr.setInt(4, seat.getStatus());
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
        String sql="SELECT * FROM SEAT WHERE SEAT_ID=?";
        try {
            preStr=conn.prepareStatement(sql);
            preStr.setString(1,seatId);
            rs =preStr.executeQuery();
            if (rs==null) {
                return null;
            }
            return new Seat(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4));
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
        String sql="SELECT * FROM SEAT";
        try {
            preStr=conn.prepareStatement(sql);
            rs =preStr.executeQuery();
            while (rs.next()){
                result.add(new Seat(rs.getString(1), rs.getInt(2),
                        rs.getInt(3),rs.getInt(4)));
            }
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
        String sql="UPDATE SEAT SET STATUS=? WHERE SEAT_ID=?";
        try {
            preStr=conn.prepareStatement(sql);
            preStr.setInt(1,seat.getStatus());
            preStr.setString(2,seat.getSeatId());
            return preStr.executeUpdate()==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
