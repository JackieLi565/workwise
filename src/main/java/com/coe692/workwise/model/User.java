package com.coe692.workwise.model;

import java.util.Optional;

public class User {
    public String email;
    private String password;
    public String firstName;
    public String lastName;
    public String middleName;

    public User(String email, Optional<String> password, String firstName, String lastName, Optional<String> middleName) {
        this.email = email;
        this.password = String.valueOf(password); // hash password in the future
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = String.valueOf(middleName);
    }

    public String getPassword() {
        return this.password; // de-hash password in future iterations of project
    }
}
