package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        User savedUser = userService.registerUser(user);
        return "User registered successfully with id " + savedUser.getId() + " " + savedUser.getFullName();
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User loginRequest) {
        Optional<User> user = userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
        if (user.isPresent()) {
            return "Login successful! Welcome, " + user.get().getFullName();
        } else {
            return "Invalid Email or Password";
        }
    }
}
