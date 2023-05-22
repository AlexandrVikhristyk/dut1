package com.example.student.entity.enums;

public enum UserRole {
    ADMIN,
    USER;

    public String getRole() {
        return "ROLE_" + name();
    }
}