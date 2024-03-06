package com.coe692.workwise.model;

public class GoogleProvider implements Provider{
    private String email;

    public GoogleProvider(String email) {
        this.email = email;
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
