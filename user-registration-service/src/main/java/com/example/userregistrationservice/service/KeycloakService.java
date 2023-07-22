package com.example.userregistrationservice.service;

import com.example.userregistrationservice.dto.UserCreateRequest;
import org.keycloak.representations.idm.UserRepresentation;

public interface KeycloakService {
    UserRepresentation createUserInKeycloak(UserCreateRequest userCreateRequest);
}
