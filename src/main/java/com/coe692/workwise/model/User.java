package com.coe692.workwise.model;

import java.util.Optional;

public class User {
    public String id;
    public String email;
    private String password;
    public String firstName;
    public String lastName;
    public String middleName;

    public User(String id, String email, String password, String firstName, String lastName, String middleName) {
        this.id = id;
        this.email = email;
        this.password = password; // hash password in the future
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public User(String email, String password, String firstname, String lastname) {
        this.email = email;
        this.password = password; // hash password in the future
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String email, String firstname, String lastname) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getPassword() {

        return this.password; // de-hash password in future iterations of project
    }
}
