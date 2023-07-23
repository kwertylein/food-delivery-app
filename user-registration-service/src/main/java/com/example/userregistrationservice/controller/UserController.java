package com.example.userregistrationservice.controller;


import com.example.userregistrationservice.dto.ApiResponse;
import com.example.userregistrationservice.dto.UserCreateRequest;
import com.example.userregistrationservice.dto.UserResponse;
import com.example.userregistrationservice.service.KeycloakService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.keycloak.representations.idm.UserRepresentation;
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
    private final KeycloakService keycloakService;

//    @PostConstruct
//    public void launch(){
//        UserCreateRequest userCreateRequest = new UserCreateRequest();
//        userCreateRequest.setName("Timur");
//        userCreateRequest.setEmail("timur@example.com");
//        userCreateRequest.setPassword("daul123123");
//        log.info("");
//        keycloakService.createUserInKeycloak(userCreateRequest);
//    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponse>> registerUser(@Valid @RequestBody UserCreateRequest userCreateRequest){
        UserRepresentation registeredUser = keycloakService.createUserInKeycloak(userCreateRequest);
        UserResponse userResponse = new UserResponse(registeredUser.getId(), registeredUser.getUsername(), registeredUser.getEmail());
        ApiResponse<UserResponse> response = new ApiResponse<>("Пользователь успешно зарегистрирован", userResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
