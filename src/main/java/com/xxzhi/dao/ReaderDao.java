package com.xxzhi.dao;

import com.xxzhi.pojo.Reader;
import com.xxzhi.tools.ConnectMysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** 对读者表的操作
 * @author xxzhi
 */
public class ReaderDao {
    static Connection conn= new ConnectMysql().getConn();
    static PreparedStatement preStr;
    static ResultSet rs;

    /**
     * 插入一条读者信息
     * @param reader 读者
     * @return 是否成功
     */
    public static boolean insert(Reader reader){
        String sql="INSERT INTO READER(READER_ID, NAME, PASSWORD, EMAIL,RESERVE_STATUS,SEAT_ID) VALUES (?,?,?,?,?,?)";
        try {
            preStr=conn.prepareStatement(sql);
            preStr.setString(1,reader.getReaderId());
            preStr.setString(2,reader.getName());
            preStr.setString(3, reader.getPassword());
            preStr.setString(4, reader.getEmail());
            preStr.setInt(5,reader.getReserveStatus());
            preStr.setString(6,reader.getSeatId());
            return preStr.executeUpdate()==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取所有的读者数据
     * @return 用户数据
     */
    public static ArrayList<Reader> selectAll(){
        ArrayList<Reader> readers=new ArrayList<>();
        String sql="SELECT * FROM READER";
        try {
            preStr=conn.prepareStatement(sql);
            rs= preStr.executeQuery();
            while (rs.next()){
                readers.add(new Reader(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getInt(8)));
            }
            conn.close();
            return readers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     *
     */
    public static Reader selectOne(String readerId){
        Connection conn= new ConnectMysql().getConn();
        String sql="SELECT * FROM READER where READER_ID=?";
        try {
            preStr=conn.prepareStatement(sql);
            preStr.setString(1,readerId);
            rs= preStr.executeQuery();
            if(rs==null){
                return null;
            }
            while (!rs.next()){
                return null;
            }
            return new Reader(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5), rs.getString(6),rs.getInt(7),rs.getInt(8));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据readerId更新信息
     * @param reader 要更新的reader
     * @return 是否成功
     */
    public static boolean updateOne(Reader reader){
        String sql="UPDATE READER SET NAME=?,PASSWORD=?,EMAIL=?,RESERVE_STATUS=?,SEAT_ID=?,SIGN_IN_STATUS=? WHERE READER_ID=?";
        try {
            preStr=conn.prepareStatement(sql);
            preStr.setString(1,reader.getName());
            preStr.setString(2, reader.getPassword());
            preStr.setString(3, reader.getEmail());
            preStr.setInt(4,reader.getReserveStatus());
            preStr.setString(5,reader.getSeatId());
            preStr.setInt(6,reader.getSignInStatus());
            preStr.setString(7,reader.getReaderId());
            return preStr.executeUpdate()==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}