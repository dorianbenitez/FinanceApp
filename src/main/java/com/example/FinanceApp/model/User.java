package com.example.FinanceApp.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "test_user_table", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String email;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private String password;

    // Hibernate expects entities to have a no-arg constructor,
    // though it does not necessarily have to be public.
    private User() {
    }

    public User(String email, String firstName, String lastName, LocalDate dateOfBirth, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId() {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail() {
        this.email = email;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName() {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
