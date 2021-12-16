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
    static private final String URL="jdbc:mysql://xxzhi.cn:3306/Library";
    private static Connection conn=null;
    static {
        try {
            //注册驱动
            Class.forName(DRIVER);
            //连接数据库
            conn= DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConn() {
        return conn;
    }
}
