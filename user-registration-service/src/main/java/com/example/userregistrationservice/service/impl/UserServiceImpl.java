package com.example.userregistrationservice.service.impl;

import com.example.userregistrationservice.converter.UserConverter;
import com.example.userregistrationservice.dto.UserCreateRequest;
import com.example.userregistrationservice.exception.UserAlreadyExistsException;
import com.example.userregistrationservice.model.User;
import com.example.userregistrationservice.repository.UserRepository;
import com.example.userregistrationservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserConverter userConverter;

    @Override
    @Transactional
    public User registerUser(UserCreateRequest userCreateRequest) {
        if(userRepository.existsByEmail(userCreateRequest.getEmail())){
            throw new UserAlreadyExistsException("Пользователь с такой почтой уже зарегистрирован");
        }

        User user = userConverter.convertToEntity(userCreateRequest);
        user.setPassword(passwordEncoder.encode(userCreateRequest.getPassword()));
        return userRepository.save(user);
    }
}
