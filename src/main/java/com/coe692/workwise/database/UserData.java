package com.coe692.workwise.database;
import com.coe692.workwise.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserData {
    public static void retriveUserList() {
        ArrayList<User> userList = new ArrayList<>();
        Connection con = DatabaseConnection.getInstance();
        String selectUsersQuery = "SELECT * FROM user";

        try (PreparedStatement preparedStatement = con.prepareStatement(selectUsersQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String f_name = resultSet.getString("f_name");
                String l_name = resultSet.getString("l_name");
                userList.add(new User(email, password, f_name, l_name));
            }
        } catch (SQLException e) {
        // Log the exception or throw a custom exception
        e.printStackTrace();
        // throw new CustomDatabaseException("Failed to retrieve users from the database", e);
    }
    }
}

