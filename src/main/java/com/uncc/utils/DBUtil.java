package com.uncc.utils;

import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: zerongliu
 * @Date: 10/29/18 22:04
 * @Description:
 */
public class DBUtil {

    /**
     * get db connection
     *
     * @param sessionFactory
     * @return
     */
    public static Connection getConnection(SqlSessionFactory sessionFactory) {
        return sessionFactory.openSession(Boolean.TRUE).getConnection();
    }

    /**
     * close connection
     *
     * @param conn
     * @param rs
     * @param statement
     * @return
     */
    public static Boolean closeConnection(Connection conn, ResultSet rs, Statement statement) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
