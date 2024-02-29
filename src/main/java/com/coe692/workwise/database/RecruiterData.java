package com.coe692.workwise.database;

import com.coe692.workwise.exception.NoDataException;
import com.coe692.workwise.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RecruiterData {

    public static Recruiter getRecruiterByEmail(String searchEmail, Provider provider) throws Exception {
        Connection conn = DatabaseConnection.getInstance();
        String query = "SELECT * FROM user u INNER JOIN recruiter r ON u.user_id = r.FK_user WHERE u.email = '%s'";
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
        String recruiterId = rs.getString("recruiter_id");
        String company = rs.getString("company");

        if (provider instanceof GoogleProvider) {
            return new Recruiter(userId, provider, firstname, lastname, image, recruiterId, company);
        }

        if (provider instanceof EmailPasswordProvider) {
            Provider p = new EmailPasswordProvider(email, password);
            return new Recruiter(userId, p, firstname, lastname, image, recruiterId, company);
        }

        throw new Exception("provider not supported");
    }
}
