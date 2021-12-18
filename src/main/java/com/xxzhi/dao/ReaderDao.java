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
    static boolean insert(Reader reader){
        String sql="INSERT INTO READER(READER_ID, NAME, PASSWORD, EMAIL) VALUES (?,?,?,?)";
        try {
            preStr=conn.prepareStatement(sql);
            preStr.setString(1,reader.getReaderId());
            preStr.setString(2,reader.getName());
            preStr.setString(3, reader.getPassword());
            preStr.setString(4, reader.getEmail());
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
    static ArrayList<Reader> selectAll(){
        ArrayList<Reader> readers=new ArrayList<>();
        String sql="SELECT * FROM READER";
        try {
            preStr=conn.prepareStatement(sql);
            rs= preStr.executeQuery();
            while (rs.next()){
                readers.add(new Reader(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
            conn.close();
            return readers;
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
    static boolean update(Reader reader){
        String sql="UPDATE READER SET NAME=?,PASSWORD=?,EMAIL=? WHERE READER_ID=?";
        try {
            preStr=conn.prepareStatement(sql);
            preStr.setString(1,reader.getName());
            preStr.setString(2, reader.getName());
            preStr.setString(3, reader.getPassword());
            preStr.setString(4, reader.getReaderId());
            return preStr.executeUpdate()==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}