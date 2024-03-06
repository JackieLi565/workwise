package com.coe692.workwise.dao;

import com.coe692.workwise.exception.NoDataException;
import com.coe692.workwise.model.Candidate;
import com.coe692.workwise.model.EmailPasswordProvider;
import com.coe692.workwise.model.GoogleProvider;
import com.coe692.workwise.model.Provider;
import com.coe692.workwise.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class CandidateDAO implements DAO<Candidate> {
    private final Connection conn;
    public CandidateDAO() {
        this.conn = DatabaseConnection.getInstance();
    }

    public Candidate findByEmail(String searchEmail) throws SQLException {
        String query = "SELECT * FROM user u INNER JOIN candidate c ON u.user_id = c.FK_user WHERE u.email = '%s'";
        String fQuery = String.format(query, searchEmail);
        PreparedStatement ps = this.conn.prepareStatement(fQuery);
        ResultSet rs = ps.executeQuery();

        if (!rs.next()) return null;

        String userId = rs.getString("user_id");
        String email = rs.getString("email");
        String password = rs.getString("password");
        String firstname = rs.getString("f_name");
        String lastname = rs.getString("l_name");
        String image = rs.getString("image");
        String candidateId = rs.getString("candidate_id");
        String experience = rs.getString("experience");
        String skills = rs.getString("skills");
        String description = rs.getString("description");
        boolean searchable = rs.getBoolean("searchable");

        if (password == null) {
            Provider provider = new GoogleProvider(email);
            return new Candidate(userId, provider, firstname, lastname, image, candidateId, experience, skills, description, searchable);
        }

        Provider p = new EmailPasswordProvider(email, password);
        return new Candidate(userId, p, firstname, lastname, image, candidateId, experience, skills, description, searchable);
    }

    @Override
    public Candidate findById(String id) throws SQLException {
        return null;
    }

    @Override
    public Map<String, Candidate> findAll() throws SQLException  {
        return null;
    }

    @Override
    public void insert(Candidate entity) throws SQLException  {
    }

    @Override
    public void delete(Candidate entity) throws SQLException  {
    }

    @Override
    public void update(Candidate entity) throws SQLException {

    }
}
