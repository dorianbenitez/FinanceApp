package com.example.FinanceApp.service;

import com.example.FinanceApp.model.User;
import com.example.FinanceApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {
    // UserService.java

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public User authenticate(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(user -> passwordEncoder.matches(password, user.getPassword()))
                .orElseThrow(() -> new UsernameNotFoundException("Invalid email or password"));
    }

    public User registerUser(User user) {
        try {
            if(!userRepository.findByEmail(user.getEmail()).isEmpty()) {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new UsernameNotFoundException("This email address already exists");
        }

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return user;
    }
}
