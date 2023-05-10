package com.example.student.service;

import com.example.student.common.exceprion.BadRequestException;
import com.example.student.entity.User;
import com.example.student.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new BadRequestException("User not found by id " + id));
    }

    public User getByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new BadRequestException("User not found by email " + email));
    }
}
