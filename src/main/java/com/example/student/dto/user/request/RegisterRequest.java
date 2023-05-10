package com.example.student.dto.user.request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;
}
