package com.workwise.candidateservice.model;

public class EmailPasswordProvider implements Provider{
    private String password;
    private String email;
    public EmailPasswordProvider(String email, String password) {
        this.email = email;
        this.password = password; // TODO: decrypt password in the future
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }
}