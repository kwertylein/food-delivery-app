package com.example.userregistrationservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Getter @Setter private Long id;

    @NotBlank(message = "Поле имя не должно быть пустым")
    @Size(max = 100, message = "Имя не должно быть длиннее 100 символов")
    @Column(name="username")
    @Getter @Setter private String name;

    @NotBlank(message = "Поле почта не должно быть пустым")
    @Email(message = "Неверный формат почты")
    @Column(name = "email")
    @Getter @Setter private  String email;

    @NotBlank(message = "Поле пароль не должно быть пустым")
    @Size(min = 6, message = "Пароль должен быть не короче 6 символов")
    @Column(name = "password")
    @Getter @Setter private String password;

}