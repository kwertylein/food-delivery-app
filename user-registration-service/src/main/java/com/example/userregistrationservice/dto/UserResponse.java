package com.example.userregistrationservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserResponse {
    private String id;
    private String name;
    private String email;

    public UserResponse(String id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }
}