package com.coe692.workwise.model;

import com.auth0.jwt.interfaces.DecodedJWT;

public class GoogleProvider implements Provider{
    private final DecodedJWT jwt;
    public GoogleProvider(DecodedJWT jwt) {
        this.jwt = jwt;
    }
    @Override
    public String getEmail() {
        return jwt.getClaim("email").asString();
    }
}
