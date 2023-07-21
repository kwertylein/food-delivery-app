package com.example.userregistrationservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private long id;

    @NotEmpty(message = "Поле имя не должно быть пустым")
    @Size(max = 100, message = "Имя не должно быть длиннее 100 символов")
    @Getter @Setter private String name;

    @NotEmpty(message = "Поле почта не должно быть пустым")
    @Email(message = "Неверный формат почты")
    @Getter @Setter private  String email;

    @NotEmpty(message = "Поле пароль не должно быть пустым")
    @Size(min = 6, message = "Пароль должен быть не короче 6 символов")
    @Getter @Setter private String password;

    public User(){

    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
