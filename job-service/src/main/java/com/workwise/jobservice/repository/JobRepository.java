package com.workwise.jobservice.repository;

import com.workwise.jobservice.common.DatabaseConnection;
import com.workwise.jobservice.model.Job;
import com.workwise.jobservice.model.Recruiter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class JobRepository {
    public static ArrayList<Job> findByFilter(String title, String loc) {
        DatabaseConnection instance = DatabaseConnection.getInstance();
        Connection conn = instance.getConnection();

        String query = "SELECT * FROM recruiter r INNER JOIN user u ON r.FK_user = u.user_id INNER JOIN job j ON j.FK_recruiter = r.recruiter_id ";
        if (title != null) query += "where title like '%" + title + "%' or description like '%" + title + "%'";
        if (loc != null) query += "and location like '%" + loc + "%'";

        ArrayList<Job> jobs = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                jobs.add(getJob(rs));
            }
        } catch (SQLException e) {
            // TODO log error
        } finally {
            instance.closeConnection();
        }
        return jobs;

    }

    private static Job getJob(ResultSet rs) throws SQLException {
        String id = rs.getString("job_id");
        String title = rs.getString("title");
        String description = rs.getString("description");
        String location = rs.getString("location");
        String recruiterId = rs.getString("FK_recruiter");
        String url = rs.getString("url");
        Date dateobj = rs.getDate("date_posted");
        Double wage = rs.getDouble("hourly_wage");
        int views = rs.getInt("interaction");
        String firstname = rs.getString("f_name");
        String lastname = rs.getString("l_name");
        String image = rs.getString("image");
        String company = rs.getString("r.company");

        Recruiter r = new Recruiter(recruiterId,firstname,lastname,image,company);

        return new Job(r, id , title, description, location, wage, dateobj.toString(), url, views);
    }
}
