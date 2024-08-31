package com.example.FinanceApp.model;

public class AuthResponse {
    private String message;
    // constructor, getters, and setters

    // Default constructor
    public AuthResponse() {
    }

    // Parameterized constructor
    public AuthResponse(String message) {
        this.message = message;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
