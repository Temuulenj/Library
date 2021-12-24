package com.xxzhi.dao;

import com.xxzhi.pojo.SignInfo;
import com.xxzhi.tools.ConnectMysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author temuulen
 */
public class SignInfoDao {
    static Connection conn= new ConnectMysql().getConn();
    static ResultSet rs;
    static PreparedStatement preStr;

    /**
     * 插入一条数据
     * @param signInfo 签到消息
     * @return 是否成功
     */
    public static boolean insert(SignInfo signInfo){
        String sql="insert into sign_info(reader_id, seat_id,SIGN_TYPE) values (?,?,?)";
        try {
            preStr=conn.prepareStatement(sql);
            preStr.setString(1,signInfo.getReaderId());
            preStr.setString(2,signInfo.getSeatId());
            preStr.setInt(3,signInfo.getSignType());
            return preStr.executeUpdate()==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 按元素获取数据
     * @param element 类型
     * @param readerId 值
     * @return 单条数据
     */
    public static SignInfo selectOne(String element,String readerId){

        if (!("READER_ID".equals(element)|"SEAT_ID".equals(element)| "SIGN_TYPE".equals(element))){
            return null;
        }
        String sql="select * from sign_info where "+element+"=?";
        try {
            preStr=conn.prepareStatement(sql);
            preStr.setString(1,readerId);
            rs= preStr.executeQuery();
            return rs==null? null:new SignInfo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5) );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
