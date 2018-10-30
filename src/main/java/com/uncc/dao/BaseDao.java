package com.uncc.dao;

import com.uncc.po.DaoResult;
import com.uncc.utils.DBUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/29/18 21:34
 * @Description:
 */
@Component
public class BaseDao {
    @Autowired
    SqlSessionFactory sessionFactory;

    public DaoResult executeQuery(String command) {
        Connection conn = DBUtil.getConnection(sessionFactory);
        Statement statement = null;
        ResultSet rs = null;
        DaoResult result = new DaoResult();
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery(command);
            if (rs != null) {
                ResultSetMetaData rsmd = rs.getMetaData();
                int headCount = rsmd.getColumnCount();
                List<String> headers = new ArrayList<String>();
                for (int i = 1; i <= headCount; i++) {
                    headers.add(rsmd.getColumnName(i));
                }
                result.setHeaders(headers);
                List<List<Object>> data = new ArrayList<List<Object>>();
                while (rs.next()) {
                    List<Object> rowResult = new ArrayList<Object>();
                    for (int i = 1; i <= headCount; i++) {
                        rowResult.add(rs.getObject(i));
                    }

                    data.add(rowResult);
                }
                result.setData(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn, rs, statement);
            return result;
        }
    }

}
