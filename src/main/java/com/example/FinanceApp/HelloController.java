package com.example.FinanceApp;

import com.example.FinanceApp.Objects.User;
import com.example.FinanceApp.Objects.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.StringJoiner;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloController {

    private final UserRepository userRepository;

    public HelloController(UserRepository userRepository) {
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
    public User addOneUser(@RequestBody User user) {
        return this.userRepository.save(user);
    }

}