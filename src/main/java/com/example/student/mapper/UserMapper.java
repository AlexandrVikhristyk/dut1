package com.example.student.mapper;

import com.example.student.dto.user.dto.UserDto;
import com.example.student.dto.user.request.LoginRequest;
import com.example.student.dto.user.request.RegisterRequest;
import com.example.student.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User fromDto(RegisterRequest dto);
    User fromDto(LoginRequest dto);
    UserDto toDto(User entity);
}
