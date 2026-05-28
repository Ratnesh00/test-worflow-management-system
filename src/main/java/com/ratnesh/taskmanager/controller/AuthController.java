package com.ratnesh.taskmanager.controller;

import com.ratnesh.taskmanager.dto.LoginRequest;
import com.ratnesh.taskmanager.dto.LoginResponse;
import com.ratnesh.taskmanager.dto.RegisterRequest;
import com.ratnesh.taskmanager.dto.RegisterResponse;
import com.ratnesh.taskmanager.entity.User;
import com.ratnesh.taskmanager.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    //Constructor Injection
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public RegisterResponse register(
            @RequestBody RegisterRequest request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        User savedUser = authService.registerUser(user);

        return new RegisterResponse(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getRole(),
                "User registered successfully"
        );
    }

    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody LoginRequest request) {

        User user = authService.loginUser(
                request.getEmail(),
                request.getPassword()
        );

        return new LoginResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole(),
                "Login successful"
        );
    }
}