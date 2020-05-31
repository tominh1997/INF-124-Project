package com.uci.chocoholic.db;

import java.sql.*;


public class DatabaseConnector {


    private DatabaseConnector() {

    }
    /*
    public static Connection getConnection() {

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return DriverManager.getConnection("jdbc:mariadb://192.168.0.209/db4lecture",
                    "root", "mytest");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
    */
    public static Connection initializeDatabase()
            throws SQLException, ClassNotFoundException
    {
        // Initialize all the information regarding
        // Database Connection
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/";
        // Database name to access
        String dbName = "chocoholic_db";
        String dbUsername = "root";
        String dbPassword = "";

        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbURL + dbName,
                dbUsername,
                dbPassword);
        return con;
    }


}
