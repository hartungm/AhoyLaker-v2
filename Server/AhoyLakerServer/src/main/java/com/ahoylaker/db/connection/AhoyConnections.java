package com.ahoylaker.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class AhoyConnections {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        properties.put("user", USERNAME);
        properties.put("password", PASSWORD);
        return DriverManager.getConnection( "jdbc:mysql://localhost:3306/ahoylaker", properties);
    }
}
