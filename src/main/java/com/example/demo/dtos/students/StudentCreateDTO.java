package com.example.demo.dtos.students;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class StudentCreateDTO {

    @NotEmpty(message = "O nome é obrigatório!")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 5 e 100 caracteres!")
    private String name;

    @NotEmpty(message = "O e-mail é obrigatório!")
    @Email(message = "O e-mail deve ser válido!")
    private String email;

    public StudentCreateDTO() {}

    public StudentCreateDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
