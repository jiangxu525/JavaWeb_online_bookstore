package com.atguigu.utils;
/*
@author: 
@create
*/

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.alibaba.druid.util.JdbcUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns = new ThreadLocal<>();

    static {
        Properties properties = new Properties();
        InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            properties.load(is);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = conns.get();
        if (conn == null) {
            try {
                conn = dataSource.getConnection();
                conns.set(conn);
                conn.setAutoCommit(false);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
         return conn;
    }

//    public static void close(Connection conn) {
//        if (conn != null) {
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public static void commitAndClose( ){
    Connection conn = conns.get();
    if(conn !=null){
        try {
            conn.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    conns.remove();
    }

    public static void rollbackAndClose(){
        Connection conn = conns.get();
        if(conn !=null){
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally{
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        conns.remove();
    }


}
