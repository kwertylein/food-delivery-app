package com.example.userregistrationservice.dto;

import com.example.userregistrationservice.model.User;
import lombok.Getter;
import lombok.Setter;

public class UserResponse {
    @Getter @Setter private long id;
    @Getter @Setter private String name;
    @Getter @Setter private String email;

    public UserResponse(long id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
