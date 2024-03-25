package com.workwise.jobservice.repository;

import com.workwise.jobservice.common.DatabaseConnection;
import com.workwise.jobservice.model.Job;
import com.workwise.jobservice.model.Recruiter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JobRepository implements DAO<Job>{
    private final Connection conn;
    public JobRepository(){
        conn = DatabaseConnection.getInstance();
    }
    @Override
    public Job findById(String id) throws SQLException {
        String query = "SELECT * FROM user u INNER JOIN recruiter r ON u.user_id = r.FK_user INNER JOIN job j ON r.recruiter_id = j.FK_recruiter WHERE j.job_id = '%s'";
        String fQuery = String.format(query, id);
        PreparedStatement ps = this.conn.prepareStatement(fQuery);

        ResultSet rs = ps.executeQuery();
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
        return new Job(r, id,title,description,location,wage,dateobj.toString(),url,views);
    }

    @Override
    public Map<String, Job> findAll() throws SQLException {
        Map<String, Job> jobMap = new HashMap<>();
        String selectUsersQuery = "SELECT * FROM recruiter r INNER JOIN user u  ON r.FK_user = u.user_id INNER JOIN job j ON j.FK_recruiter = r.recruiter_id";
        PreparedStatement ps = this.conn.prepareStatement(selectUsersQuery);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
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
            Job j = new Job(r, id , title, description, location, wage, dateobj.toString(), url, views);
            jobMap.put(id, j);
        }
        return jobMap;
    }

    @Override
    public void insert(Job entity) throws SQLException {
        String id = entity.getId();
        String title = entity.getTitle();
        String recruiter_id = entity.getRecruiter().getId();
        String description = entity.getDescription();
        String location = entity.getLocation();
        String company = entity.getCompany();;
        String url = entity.getUrl();
        String date = String.valueOf(entity.getDate());
        Double wage = entity.getPay();
        int views = entity.getInteraction();

        String insertJobStmt = "INSERT INTO job (job_id, FK_recruiter, title, description, location, hourly_wage, company, date_posted, url, interaction) \n" +
                "VALUES ('%s','%s','%s','%s','%s', %s,'%s','%s','%s', %d)";
        String fStmt = String.format(insertJobStmt, id, recruiter_id, title, description, location, wage, company, date, url, views);
        PreparedStatement ps = this.conn.prepareStatement(fStmt);
        ps.executeUpdate();
    }

    @Override
    public void delete(Job entity) throws SQLException {
        String id = entity.getId();
        String deleteJobStmt = "DELETE FROM job WHERE job_id = '%s'";
        String fStmt = String.format(deleteJobStmt, id);
        PreparedStatement ps = this.conn.prepareStatement(fStmt);
        ps.executeUpdate();
    }

    @Override
    public void update(Job entity) throws SQLException { //Similar to insert

    }
}
