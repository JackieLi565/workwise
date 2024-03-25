package com.workwise.candidateservice.model;

public class OAuthProvider implements Provider {
    private String email;
    private final String name = "oauth";

    public OAuthProvider(String email) {
        this.email = email;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }
}
