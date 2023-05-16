package com.example.student.controller;

import com.example.student.dto.user.dto.UserDto;
import com.example.student.dto.user.request.LoginRequest;
import com.example.student.dto.user.request.RegisterRequest;
import com.example.student.mapper.UserMapper;
import com.example.student.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserMapper userMapper;

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody RegisterRequest register) {
        UserDto user = userMapper.toDto(authService.register(userMapper.fromDto(register)));
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginRequest login) {
        authService.login(userMapper.fromDto(login));
        return ResponseEntity.ok().build();
    }
}
