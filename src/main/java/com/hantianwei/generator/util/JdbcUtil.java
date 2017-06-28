package com.hantianwei.generator.util;

import com.hantianwei.generator.model.Config;

import java.sql.*;

/**
 * Created by tianwei on 2017/6/28.
 */
public class JdbcUtil {
    //定义一个连接对象
    private Connection conn = null;
    //定义连接数据库的url资源
    private String url = String.format("jdbc:mysql://%s:%d/%s?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useUnicode=true&&autoReconnect=true&useSSL=false", Config.DB_SERVER, Config.DB_PORT, Config.DB_NAME);

    //定义连接数据库的用户名和密码
    private String userName = Config.DB_USER;
    private String passWord = Config.DB_PASSWORD;

    //加载数据库连接驱动
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, userName, passWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    //关闭数据库
    public void closeALL(Connection conn, Statement st, ResultSet rs, PreparedStatement pst) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
            if (pst != null)
                pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
