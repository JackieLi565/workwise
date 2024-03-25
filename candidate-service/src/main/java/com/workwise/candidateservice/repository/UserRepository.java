package com.workwise.candidateservice.repository;

import com.workwise.candidateservice.common.DatabaseConnection;
import com.workwise.candidateservice.model.EmailPasswordProvider;
import com.workwise.candidateservice.model.OAuthProvider;
import com.workwise.candidateservice.model.Provider;
import com.workwise.candidateservice.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Optional;

public class UserRepository implements DAO<User> {
    private Connection con;

    public UserRepository() {
        this.con = DatabaseConnection.getInstance();
    }
    public Optional<User> findByEmail(String userEmail) throws SQLException {
        Statement statement = this.con.createStatement();
        String query = String.format("SELECT * FROM user WHERE user.email = '%s'", userEmail);
        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {
            String id = rs.getString("user_id");
            String email = rs.getString("email");
            String password = rs.getString("password");
            String fName = rs.getString("f_name");
            String lName = rs.getString("l_name");
            String image = rs.getString("image");

            Provider provider;

            if (password == null) {
                provider = new OAuthProvider(email);
            } else {
                provider = new EmailPasswordProvider(email, password);
            }

            return Optional.of(new User(provider, id, fName, lName, image));
        }

        return Optional.empty();
    }

    @Override
    public Optional<User> findById(String id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public Map<String, User> findAll() throws SQLException {
        return null;
    }

    @Override
    public void insert(User entity) throws SQLException {

    }

    @Override
    public void delete(User entity) throws SQLException {

    }

    @Override
    public void update(User entity) throws SQLException {

    }
}
