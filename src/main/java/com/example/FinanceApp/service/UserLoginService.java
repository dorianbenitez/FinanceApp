package com.example.FinanceApp.service;

import com.example.FinanceApp.model.User;
import com.example.FinanceApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {
    // UserService.java

        @Autowired
        private UserRepository userRepository;

        public User authenticate(String email, String password) {
            return userRepository.findByEmail(email)
                    .filter(user -> new BCryptPasswordEncoder().matches(password, user.getPassword()))
                    .orElseThrow(() -> new UsernameNotFoundException("Invalid email or password"));
        }
    }
