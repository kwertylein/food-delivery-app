package com.example.userregistrationservice.converter;

import com.example.userregistrationservice.dto.UserCreateRequest;
import com.example.userregistrationservice.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public User convertToEntity(UserCreateRequest userCreateRequest){
        User user = new User();
        user.setName(userCreateRequest.getName());
        user.setEmail(userCreateRequest.getEmail());
        return user;
    }
}
