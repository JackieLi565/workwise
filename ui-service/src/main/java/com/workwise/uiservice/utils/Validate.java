package com.workwise.uiservice.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Optional;

public class Validate {
    public static Optional<DecodedJWT> jwt(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(System.getenv("JWT_SECRET"));
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("workwise")
                    .build();

            DecodedJWT decodedJWT = verifier.verify(token);

            return Optional.ofNullable(decodedJWT);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
