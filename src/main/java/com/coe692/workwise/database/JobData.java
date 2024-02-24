package com.coe692.workwise.database;

import com.coe692.workwise.model.Job;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class JobData {
    public static void retrieveJobList() {
        ArrayList<Job> jobList = new ArrayList<>();
        Connection con = DatabaseConnection.getInstance();
        String selectUsersQuery = "SELECT * FROM job";

        try (PreparedStatement preparedStatement = con.prepareStatement(selectUsersQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String location = resultSet.getString("location");
                String recruiter = resultSet.getString("recruiter");
                String company = resultSet.getString("company");
                Date dateobj = resultSet.getDate("location");
                Double wage = resultSet.getDouble("hourly_wage");
                int views = resultSet.getInt("interaction");

                jobList.add(new Job(title, description, location, company, wage, dateobj.toString(),views, recruiter ));
            }
        } catch (SQLException e) {
            // Log the exception or throw a custom exception
            e.printStackTrace();
            // throw new CustomDatabaseException("Failed to retrieve users from the database", e);
        }
    }
}
