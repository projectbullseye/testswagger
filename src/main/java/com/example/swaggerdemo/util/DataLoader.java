package com.example.swaggerdemo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.swaggerdemo.model.User;
import com.example.swaggerdemo.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Component
public class DataLoader {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    @PostConstruct
    public void loadUser() {
        if (repo.findByUsername("admin").isEmpty()) {
            User u = new User();
            u.setUsername("admin");
            u.setPassword(encoder.encode("password"));
            u.setRole("ROLE_ADMIN");
            repo.save(u);
        }
    }
}

