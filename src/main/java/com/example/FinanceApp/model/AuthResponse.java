package com.example.FinanceApp.model;

public class AuthResponse {
    private String message;
    private String email;
    // constructor, getters, and setters

    // Default constructor
    public AuthResponse() {
    }

    // Parameterized constructor
    public AuthResponse(String message, String email) {
        this.message = message;
        this.email = email;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
