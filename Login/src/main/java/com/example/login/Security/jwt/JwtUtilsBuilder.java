package com.example.login.Security.jwt;

public class JwtUtilsBuilder {
    private int jwtExpirationMs;

    public JwtUtilsBuilder setJwtExpirationMs(int jwtExpirationMs) {
        this.jwtExpirationMs = jwtExpirationMs;
        return this;
    }

    public JwtUtils createJwtUtils() {
        return new JwtUtils(jwtExpirationMs);
    }
}