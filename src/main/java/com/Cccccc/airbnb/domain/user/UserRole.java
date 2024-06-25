package com.Cccccc.airbnb.domain.user;

public enum UserRole {
    USER("USER"),
    HOST("HOST");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }
}

