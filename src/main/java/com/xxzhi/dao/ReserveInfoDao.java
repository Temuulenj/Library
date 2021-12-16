package com.xxzhi.dao;

import com.xxzhi.pojo.ReserveInfo;
import com.xxzhi.tools.ConnectMysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** 对预约信息表的操作
 * @author xxzhi
 */
public class ReserveInfoDao {
    static Connection conn= new ConnectMysql().getConn();
    static PreparedStatement preStr;
    static ResultSet rs;

    /**
     * 插入一条预约数据
     * @param reserveInfo 预约信息
     * @return 是否成功
     */
    static boolean insert(ReserveInfo reserveInfo){
        String sql="INSERT INTO RESERVE_INFO (READER_ID,SEAT_ID,START_TIME,END_TIME) VALUES (?,?,?,?)";
        try {
            preStr=conn.prepareStatement(sql);
            preStr.setString(1,reserveInfo.getReaderId());
            preStr.setString(2,reserveInfo.getSeatId());
            preStr.setString(3,reserveInfo.getStartTime());
            preStr.setString(4,reserveInfo.getEndTime());
            return preStr.executeUpdate()==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取所有预约记录
     * @return 所有预约记录
     */
    static ArrayList<ReserveInfo> selectAll(){
        ArrayList<ReserveInfo> result = new ArrayList<>();
        String sql="SELECT * FROM RESERVE_INFO";
        try {
            preStr=conn.prepareStatement(sql);
            rs =preStr.executeQuery();
            while (rs.next()){
                result.add(new ReserveInfo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取某位读者的预约记录
     * @param reader 读者
     * @return 该读者的预约记录
     */
    static ArrayList<ReserveInfo> selectByReader(String reader){
        ArrayList<ReserveInfo> result = new ArrayList<>();
        String sql="SELECT * FROM RESERVE_INFO WHERE READER_ID=?";
        try {
            preStr=conn.prepareStatement(sql);
            preStr.setString(1,reader);
            rs =preStr.executeQuery();
            while (rs.next()){
                result.add(new ReserveInfo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
