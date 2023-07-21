package com.example.userregistrationservice.service;

import com.example.userregistrationservice.dto.UserCreateRequest;
import com.example.userregistrationservice.model.User;

public interface UserService {
    User registerUser(UserCreateRequest userCreateRequest);
}
