package com.example.userregistrationservice.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@RequiredArgsConstructor
public class UserResponse {
    @Getter @Setter private String id;
    @Getter @Setter private String name;
    @Getter @Setter private String email;

    public UserResponse(String id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }
}