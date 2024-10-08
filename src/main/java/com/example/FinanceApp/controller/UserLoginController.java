package com.example.FinanceApp.controller;

import com.example.FinanceApp.model.AuthResponse;
import com.example.FinanceApp.model.LoginRequest;
import com.example.FinanceApp.model.User;
import com.example.FinanceApp.repository.UserRepository;
import com.example.FinanceApp.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.StringJoiner;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;
    @Autowired
    private final UserRepository userRepository;

    public UserLoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/test")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/getUsers")
    public Iterable<User> testGetUsers() {
        Iterable<User> result = this.userRepository.findAll();
        StringJoiner joiner = new StringJoiner(", ");

        if(result != null && result.iterator().hasNext()) {
            for (User user : result) {
                String userString = String.format("User{id=%d, email='%s', firstName='%s', lastName='%s', dateOfBirth=%s, password='%s'}",
                        user.getId(),
                        user.getEmail(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getDateOfBirth(),
                        user.getPassword());
                joiner.add(userString);
            }
            System.out.println(joiner.toString());
            return result;
        } else {
            System.out.println("There is no data available.");
            return result;
        }
    }

    @PostMapping("/addUser")
    public ResponseEntity<AuthResponse> addOneUser(@RequestBody User user) {
        try {
            userLoginService.registerUser(user);
            AuthResponse authResponse = new AuthResponse("User registration success!");
            return ResponseEntity.ok(authResponse);
        }
        catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new AuthResponse("This email address already exists"));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new AuthResponse("There was an issue creating your account. Please try again."));
        }
    }

    @PostMapping("/userLogin")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            User user = userLoginService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());
            return ResponseEntity.ok(new AuthResponse("Login Successful"));
        } catch (UsernameNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new AuthResponse("Email/Password combination not found"));
        }
    }
    }