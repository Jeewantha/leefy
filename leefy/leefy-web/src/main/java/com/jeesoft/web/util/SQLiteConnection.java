package com.jeesoft.web.util;

import org.springframework.stereotype.Component;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Component
public class SQLiteConnection {

    public static Connection getConnection() {

        Connection conn = null;

        try{
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/sqlite");
            conn = ds.getConnection();
            System.out.println(conn.getMetaData().getDriverName());
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from SYSTEM_PROPERTIES");
            while (rs.next()) {
                System.out.println(rs.getString("PROPERTY_KEY"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
