package com.coe692.workwise.model;

public class EmailPasswordProvider implements Provider{
    final private String password;
    final private String email;
    public EmailPasswordProvider(String email, String password) {
        this.email = email;
        this.password = password; // hash password
    }
    @Override
    public String getEmail() {
        return this.email;
    }
}
