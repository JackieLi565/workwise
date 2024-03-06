package com.coe692.workwise.dao;

import com.coe692.workwise.exception.NoDataException;
import com.coe692.workwise.model.*;
import com.coe692.workwise.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class RecruiterDAO implements DAO<Recruiter> {
    private final Connection conn;
    public RecruiterDAO() {
        this.conn = DatabaseConnection.getInstance();
    }

    public Recruiter findByEmail(String searchEmail) throws SQLException, NoDataException {
        String query = "SELECT * FROM user u INNER JOIN recruiter r ON u.user_id = r.FK_user WHERE u.email = '%s'";
        String fQuery = String.format(query, searchEmail);
        PreparedStatement ps = this.conn.prepareStatement(fQuery);
        ResultSet rs = ps.executeQuery();

        if (!rs.next()) throw new NoDataException();

        String userId = rs.getString("user_id");
        String email = rs.getString("email");
        String password = rs.getString("password");
        String firstname = rs.getString("f_name");
        String lastname = rs.getString("l_name");
        String image = rs.getString("image");
        String recruiterId = rs.getString("recruiter_id");
        String company = rs.getString("company");

        if (password == null) {
            Provider gP = new GoogleProvider(email);
            return new Recruiter(userId, gP, firstname, lastname, image, recruiterId, company);
        }

        Provider p = new EmailPasswordProvider(email, password);
        return new Recruiter(userId, p, firstname, lastname, image, recruiterId, company);
    }

    @Override
    public Recruiter findById(String id) throws SQLException {
        String query = "SELECT * FROM user u INNER JOIN recruiter r ON u.user_id = r.FK_user WHERE r.recruiter_id = '%s'";
        String fQuery = String.format(query, id);
        PreparedStatement ps = this.conn.prepareStatement(fQuery);
        ResultSet rs = ps.executeQuery();

        if (!rs.next()) return null;

        String userId = rs.getString("user_id");
        String email = rs.getString("email");
        String password = rs.getString("password");
        String firstname = rs.getString("f_name");
        String lastname = rs.getString("l_name");
        String image = rs.getString("image");
        String recruiterId = rs.getString("recruiter_id");
        String company = rs.getString("company");


        if (password == null) {
            Provider provider = new GoogleProvider(email);
            return new Recruiter(userId, provider, firstname, lastname, image, recruiterId, company);
        }

        Provider provider = new EmailPasswordProvider(email, password);
        return new Recruiter(userId, provider, firstname, lastname, image, recruiterId, company);
    }

    @Override
    public Map<String, Recruiter> findAll() throws SQLException  {
        return null;
    }

    @Override
    public void insert(Recruiter entity) throws SQLException  {
    }

    @Override
    public void delete(Recruiter entity) throws SQLException  {
    }

    @Override
    public void update(Recruiter entity) throws SQLException {

    }
}
