package com.revature.courses.util;

//represents a physical connection to our database
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//singleton connection instance
public class ConnectionUtil {
    // to make this class a singleton, we'll need the following things
    // private static instance of a connection
    private static Connection conn = null;
    // private constructor
    private ConnectionUtil(){}
    // public static get instance method

    public static Connection getConnection(){
        // check to see if there is a connection instance already
        // if there is, return it
        try {
            if (conn != null && !conn.isClosed()){
                System.out.println("Using a previously made connection.");
                return conn;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        // if not, create new one

        // insecure method (hardcode secure information)
        /*
        String url = "jdbc:postgresql://database-1.czkmk1xfv29p.us-east-2.rds.amazonaws.com:5432/postgres";
        String username = "postgres";
        String password = "elephant";

        try {
            System.out.println("Creating new connection...");
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Couldn't establish connection...");
            throw new RuntimeException(e);
        }
        */

        // more secure method (application.properties)
        /*
        String url = "";
        String username = "";
        String password = "";

        Properties prop = new Properties();
        try {
            prop.load(new FileReader("src/main/resources/application.properties"));
            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");

            System.out.println("Creating new connection...");
            conn = DriverManager.getConnection(url, username, password);
        } catch (IOException e) {
            System.out.println("Could not load properties file");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Could not establish connection");
            e.printStackTrace();
        }

        */

        // most secure method (env)
        // set env variables in the entrypoint class to the application. (App, Main ect...)
        String url = System.getenv("url");
        String username = System.getenv("username");
        String password = System.getenv("password");

        try {
            System.out.println("Creating new connection...");
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Couldn't establish connection...");
            throw new RuntimeException(e);
        }

        return conn;
    }
}
