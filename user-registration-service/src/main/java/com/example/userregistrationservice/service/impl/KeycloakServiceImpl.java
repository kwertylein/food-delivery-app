package com.example.userregistrationservice.service.impl;

import com.example.userregistrationservice.dto.UserCreateRequest;
import com.example.userregistrationservice.service.KeycloakService;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class KeycloakServiceImpl implements KeycloakService {
    @Value("${keycloak.realm}")
    private final String realmName;
    private final Keycloak keycloak;

    @Override
    public UserRepresentation createUserInKeycloak(UserCreateRequest userCreateRequest){
        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setUsername(userCreateRequest.getName());
        userRepresentation.setEmail(userCreateRequest.getEmail());
        userRepresentation.setEnabled(true);

        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
        credentialRepresentation.setType(CredentialRepresentation.PASSWORD);
        credentialRepresentation.setValue(userCreateRequest.getPassword());
        credentialRepresentation.setTemporary(false);

        userRepresentation.setCredentials(Collections.singletonList(credentialRepresentation));

        UsersResource users = keycloak.realm(realmName).users();

        users.create(userRepresentation);
        return userRepresentation;

    }
}
