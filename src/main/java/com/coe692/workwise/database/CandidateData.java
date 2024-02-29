package com.coe692.workwise.database;

import com.coe692.workwise.exception.NoDataException;
import com.coe692.workwise.model.Candidate;
import com.coe692.workwise.model.EmailPasswordProvider;
import com.coe692.workwise.model.GoogleProvider;
import com.coe692.workwise.model.Provider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CandidateData {
    public static Candidate getCandidateByEmail(String searchEmail, Provider provider) throws Exception {
        Connection conn = DatabaseConnection.getInstance();
        String query = "SELECT * FROM user u INNER JOIN candidate c ON u.user_id = c.FK_user WHERE u.email = '%s'";
        String fQuery = String.format(query, searchEmail);
        PreparedStatement ps = conn.prepareStatement(fQuery);
        ResultSet rs = ps.executeQuery();

        if (!rs.next()) throw new NoDataException();

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

        if (provider instanceof GoogleProvider) {
            return new Candidate(userId, provider, firstname, lastname, image, candidateId, experience, skills, description, searchable);
        }

        if (provider instanceof EmailPasswordProvider) {
            Provider p = new EmailPasswordProvider(email, password);
            return new Candidate(userId, p, firstname, lastname, image, candidateId, experience, skills, description, searchable);
        }

        throw new Exception("provider not supported");
    }
}
