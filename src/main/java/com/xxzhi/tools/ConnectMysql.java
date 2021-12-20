package com.xxzhi.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** 连接数据库
 * @author xxzhi
 *
 */
public class ConnectMysql {
    static private final String USER="root";
    static private final String PASSWORD="024019";
    static private final String DRIVER="com.mysql.cj.jdbc.Driver";
    static private final String URL="jdbc:mysql://localhost:3306/library";

    public Connection getConn() {
        Connection conn=null;
        try {
            //注册驱动
            Class.forName(DRIVER);
            //连接数据库
            conn= DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}