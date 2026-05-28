package com.ratnesh.taskmanager.controller;

import com.ratnesh.taskmanager.dto.LoginRequest;
import com.ratnesh.taskmanager.dto.RegisterRequest;
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
    public User register(@RequestBody RegisterRequest request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        return authService.registerUser(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginRequest request){

        return authService.loginUser(request.getEmail(), request.getPassword());
    }
}