package com.example.FinanceApp.Objects;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="test_user_table", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    // Hibernate expects entities to have a no-arg constructor,
    // though it does not necessarily have to be public.
    private User() {}

    public User(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }
}
