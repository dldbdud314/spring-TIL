package com.tobyspring.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NUserDao extends UserDao{
    @Override
    public Connection getConnection() throws SQLException {
        //N사 DB connection 코드
        return DriverManager.getConnection("jdbc:h2:~/tobyspring", "sa", "");
    }
}
