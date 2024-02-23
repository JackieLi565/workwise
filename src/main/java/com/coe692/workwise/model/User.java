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

    //Just temporary when @jackie figures out how to hash and de hash which I think has more to do with html
    public User(String email, String password, String firstname, String lastname) {
        this.email = email;
        this.password = password; // hash password in the future
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getPassword() {

        return this.password; // de-hash password in future iterations of project
    }
}
