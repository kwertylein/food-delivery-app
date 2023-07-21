package com.example.userregistrationservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserCreateRequest {
    @NotBlank(message = "Поле имя не должно быть пустым")
    @Size(max = 100, message = "Имя не должно быть длиннее 100 символов")
    @Getter @Setter private String name;

    @NotBlank(message = "Поле почта не должно быть пустым")
    @Email(message = "Неверный формат почты")
    @Getter @Setter private  String email;

    @NotBlank(message = "Поле пароль не должно быть пустым")
    @Size(min = 6, message = "Пароль должен быть не короче 6 символов")
    @Getter @Setter private String password;
}
