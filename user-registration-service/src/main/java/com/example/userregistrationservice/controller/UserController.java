package com.example.userregistrationservice.controller;


import com.example.userregistrationservice.dto.ApiResponse;
import com.example.userregistrationservice.dto.UserCreateRequest;
import com.example.userregistrationservice.dto.UserResponse;
import com.example.userregistrationservice.model.User;
import com.example.userregistrationservice.service.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostConstruct
    public void launch(){
        UserCreateRequest userCreateRequest = new UserCreateRequest();
        userCreateRequest.setName("Daulet");
        userCreateRequest.setEmail("dauletloh@example.com");
        userCreateRequest.setPassword("daulet123123");
        userService.registerUser(userCreateRequest);
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponse>> registerUser(@Valid @RequestBody UserCreateRequest userCreateRequest){
        User registeredUser = userService.registerUser(userCreateRequest);
        UserResponse userResponse = new UserResponse(registeredUser.getId(), registeredUser.getName(), registeredUser.getEmail());
        ApiResponse<UserResponse> response = new ApiResponse<>("Пользователь успешно зарегистрирован", userResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
