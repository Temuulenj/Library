package com.xxzhi.dao;

import com.xxzhi.pojo.ViolationInfo;
import com.xxzhi.tools.ConnectMysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** 对违约信息表的操作
 * @author xxzhi
 */
public class ViolationInfoDao {
    static Connection conn = new ConnectMysql().getConn();
    static PreparedStatement preStr;
    static ResultSet rs;
    public static boolean insert(ViolationInfo violationInfo){
        String sql="INSERT INTO VIOLATION_INFO(READER_ID,TYPE,SEAT_ID) VALUES (?,?,?)";
        try {
            preStr=conn.prepareStatement(sql);
            preStr.setString(1, violationInfo.getReaderId());
            preStr.setInt(2, violationInfo.getType());
            preStr.setString(3, violationInfo.getSeatId());
            return preStr.executeUpdate()==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 通过读者ID返回该读者的所有违规记录
     * @param readerId 读者ID
     * @return 该读者所有的违规记录
     */
    public static ArrayList<ViolationInfo> selectByReader(String readerId){
        ArrayList<ViolationInfo> result = new ArrayList<>();
        String sql="SELECT * FROM VIOLATION_INFO WHERE READER_ID=?";
        try {
            preStr=conn.prepareStatement(sql);
            preStr.setString(1,readerId);
            rs =preStr.executeQuery();
            while (rs.next()){
                result.add(new ViolationInfo(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getString(5)));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<ViolationInfo> selectAll(){
        ArrayList<ViolationInfo> result = new ArrayList<>();
        String sql="SELECT * FROM VIOLATION_INFO";
        try {
            preStr=conn.prepareStatement(sql);
            rs =preStr.executeQuery();
            while (rs.next()){
                result.add(new ViolationInfo(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getString(5)));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
