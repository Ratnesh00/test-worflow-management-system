package com.ratnesh.taskmanager.service;

import com.ratnesh.taskmanager.entity.User;
import com.ratnesh.taskmanager.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passEncoder;
    }

    public User registerUser(User user) {

        // Check if email already exists
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        // Encrypt password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save user
        return userRepository.save(user);
    }

    public User loginUser(String email, String password){

        //Check if User exists
        User user = userRepository.findByEmail(email).
                orElseThrow(() -> new RuntimeException("User not found."));

        //Match the password entered by User with th password in DB
        boolean passwordMatches = passwordEncoder.matches(password, user.getPassword());

        //If Password does not match, throw Exception
        if(!passwordMatches){
            throw new RuntimeException("Invalid password");
        }

        return user;
    }
}
