package com.workwise.candidateservice.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() {

        try {
            String URL = System.getenv("DATABASE_URL");
            String USERNAME = System.getenv("DATABASE_USERNAME");
            String PASSWORD = System.getenv("DATABASE_PASSWORD");

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance.connection;
    }
}
