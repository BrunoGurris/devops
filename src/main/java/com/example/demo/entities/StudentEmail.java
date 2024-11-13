package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Embeddable
public class StudentEmail {

    @Email(message = "O e-mail fornecido não é válido!")
    @NotEmpty(message = "O e-mail é obrigatório!")
    @Column(unique = true)
    private String email;

    protected StudentEmail() {}

    public StudentEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
