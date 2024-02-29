package com.coe692.workwise.database;

import com.coe692.workwise.model.Job;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JobData {

    public static Map<String, Job> retrieveJobList() {
        Map<String, Job> jobMap = new HashMap<>();
        Connection con = DatabaseConnection.getInstance();
        String selectUsersQuery = "SELECT * FROM job";
        try (PreparedStatement preparedStatement = con.prepareStatement(selectUsersQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String id = resultSet.getString("job_id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String location = resultSet.getString("location");
                String recruiter = resultSet.getString("FK_recruiter");
                String company = resultSet.getString("company");
                Date dateobj = resultSet.getDate("date_posted");
                Double wage = resultSet.getDouble("hourly_wage");
                int views = resultSet.getInt("interaction");
                jobMap.put(id, new Job(id , title, description, location, company, wage, dateobj.toString(),views, recruiter));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobMap;
    }
}
