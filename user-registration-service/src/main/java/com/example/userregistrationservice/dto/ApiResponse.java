package com.example.userregistrationservice.dto;

import lombok.Getter;
import lombok.Setter;

public class ApiResponse<T> {

    @Getter @Setter private String message;
    @Getter @Setter private T data;

    public ApiResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }
}
