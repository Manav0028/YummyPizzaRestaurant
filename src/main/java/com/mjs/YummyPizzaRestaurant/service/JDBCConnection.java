package com.mjs.YummyPizzaRestaurant.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yummy_pizza_restro", "root", "Jwl86mysql");
            return conn;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
