package org.example.util;

import com.sun.security.jgss.GSSUtil;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

    private static Connection conn = null;

    private ConnectionUtil(){};

    public static Connection getConnection(){
        try {
            if (conn != null && !conn.isClosed()){
                System.out.println("using a previously made connection");
                return conn;
            }
        } catch (SQLException e) {
            System.out.println("Couldn't establish connection");
            return null;
        }

        String url      = "";
        String username = "";
        String password = "";

        Properties prop = new Properties();

        try {
            prop.load(new FileReader("src/main/resources/application.properties"));

            url      = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");

            conn = DriverManager.getConnection(url,username,password);
        } catch (IOException e) {
            System.out.println("Properties filer not found");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("Could not establish connection");
            throw new RuntimeException(e);
        }

        return conn;
    }

    // static block -- a piece of code that automatically gets loaded in ONCE
    // when i spin up the actual application whether i call a constructor

    static{
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("failed to load the PostgreSQL driver");
            throw new RuntimeException(e);
        }
    }
}
