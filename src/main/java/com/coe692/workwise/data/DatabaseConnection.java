package com.coe692.workwise.data;

import java.sql.Connection;
import java.sql.DriverManager;
import io.github.cdimascio.dotenv.Dotenv;
public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() {

        try {
            Dotenv dotenv = Dotenv.load();
            String URL = dotenv.get("DATABASE_URL");
            String USERNAME = dotenv.get("DATABASE_USERNAME");
            String PASSWORD = dotenv.get("DATABASE_PASSWORD");

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}