package com.itschool.food.delivery.controllers;

import com.itschool.food.delivery.models.dtos.UserDTO;
import com.itschool.food.delivery.models.entities.User;
import com.itschool.food.delivery.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
        UserService.register(userDTO);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequestDTO loginRequest) {
        String token = userService.login(loginRequest);
        return ResponseEntity.ok(token);
    }

    @PutMapping("/profile")
    public ResponseEntity<String> updateProfile(@RequestBody UserDTO userDTO) {
        userService.updateProfile(UserDTO);
        return ResponseEntity.ok("Profile updated successfully");
    }
}