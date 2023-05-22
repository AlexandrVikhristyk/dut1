package com.example.student.common.util;

import com.example.student.entity.Role;
import com.example.student.entity.User;
import com.example.student.entity.enums.UserRole;
import com.example.student.repository.RoleRepository;
import com.example.student.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

@Component
public class DummyDataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${admin.login}")
    private String adminLogin;

    @Value("${admin.password}")
    private String adminPassword;

    @Autowired
    public DummyDataLoader(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        Role userRole = new Role();
        userRole.setName(UserRole.USER.getRole());
        roleRepository.save(userRole);

        Role adminRole = new Role();
        adminRole.setName(UserRole.ADMIN.getRole());
        roleRepository.save(adminRole);

        User user = new User();
        user.setEmail("user");
        user.setPassword(passwordEncoder.encode("password"));
        user.setRoles(Collections.singleton(userRole));
        userRepository.save(user);

        User admin = new User();
        admin.setEmail(adminLogin);
        admin.setPassword(passwordEncoder.encode(adminPassword));
        admin.setRoles(Collections.singleton(adminRole));
        userRepository.save(admin);

        User adminUser = new User();
        adminUser.setEmail("adminUser");
        adminUser.setPassword(passwordEncoder.encode("password"));
        adminUser.setRoles(Arrays.asList(adminRole, userRole));
        userRepository.save(adminUser);
    }
}
