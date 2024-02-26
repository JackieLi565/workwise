package com.coe692.workwise.database;
import com.coe692.workwise.model.User;
import com.coe692.workwise.exception.NoDataException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserData {
    public static void getAllUsers() {
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
            e.printStackTrace();
        }
    }

    public static User getUserByEmail(String email) throws NoDataException, SQLException {
        Connection conn = DatabaseConnection.getInstance();
        String query = "SELECT * FROM user WHERE email='%s'";
        query = String.format(query, email);

        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        if (!rs.next()) throw new NoDataException();

        String id = rs.getString("user_id");
        String uEmail = rs.getString("email");
        String f_name = rs.getString("f_name");
        String l_name = rs.getString("l_name");

        return new User(id, uEmail, f_name, l_name);
    }
}

