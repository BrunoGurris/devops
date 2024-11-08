package com.example.demo.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class StudentEmail {

    private String email;

    protected StudentEmail() {}

    public StudentEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
