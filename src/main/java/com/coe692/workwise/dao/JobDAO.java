package com.coe692.workwise.dao;

import com.coe692.workwise.model.Job;
import com.coe692.workwise.model.Recruiter;
import com.coe692.workwise.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JobDAO implements DAO<Job> {

    private final Connection conn;
    public JobDAO() {
        this.conn = DatabaseConnection.getInstance();
    }

    @Override
    public Job findById(String id) throws SQLException  {
        return null;
    }

    @Override
    public Map<String, Job> findAll() throws SQLException {
        Map<String, Job> jobMap = new HashMap<>();
        String selectUsersQuery = "SELECT * FROM job";
        PreparedStatement preparedStatement = this.conn.prepareStatement(selectUsersQuery);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String id = resultSet.getString("job_id");
            String title = resultSet.getString("title");
            String description = resultSet.getString("description");
            String location = resultSet.getString("location");
            String recruiterId = resultSet.getString("FK_recruiter");
            String url = resultSet.getString("url");
            Date dateobj = resultSet.getDate("date_posted");
            Double wage = resultSet.getDouble("hourly_wage");
            int views = resultSet.getInt("interaction");

            Recruiter recruiter = new RecruiterDAO().findById(recruiterId);
            Job job = new Job(recruiter, id , title, description, location, wage, dateobj.toString(), url, views);
            jobMap.put(id, job);
        }

        return jobMap;
    }

    @Override
    public void insert(Job entity) throws SQLException  {

    }

    @Override
    public void delete(Job entity) throws SQLException  {
    }

    @Override
    public void update(Job entity) throws SQLException {

    }
}
