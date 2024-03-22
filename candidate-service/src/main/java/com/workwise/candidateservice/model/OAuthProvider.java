package com.workwise.candidateservice.model;

class OAuthProvider implements Provider {
    private String email;

    public OAuthProvider(String email) {
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
