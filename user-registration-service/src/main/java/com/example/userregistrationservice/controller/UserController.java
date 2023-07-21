package com.example.userregistrationservice.controller;


import com.example.userregistrationservice.dto.ApiResponse;
import com.example.userregistrationservice.dto.UserResponse;
import com.example.userregistrationservice.model.User;
import com.example.userregistrationservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponse>> registerUser(@Valid @RequestBody User user){
        User registeredUser = userService.registerUser(user);
        UserResponse userResponse = new UserResponse(registeredUser.getId(), registeredUser.getName(), registeredUser.getEmail());
        ApiResponse<UserResponse> response = new ApiResponse<>("Пользователь успешно зарегистрирован", userResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
