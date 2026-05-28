package com.ratnesh.taskmanager.dto;

import com.ratnesh.taskmanager.entity.Role;

public class RegisterResponse {

    private Long id;
    private String name;
    private String email;
    private Role role;
    private String message;

    public RegisterResponse() {
    }

    public RegisterResponse(Long id,
                            String name,
                            String email,
                            Role role,
                            String message) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public String getMessage() {
        return message;
    }
}