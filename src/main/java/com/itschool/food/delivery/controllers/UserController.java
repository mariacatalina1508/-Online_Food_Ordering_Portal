package com.itschool.food.delivery.controllers;

import com.itschool.food.delivery.models.dtos.UserDTO;
import com.itschool.food.delivery.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("api/users")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

    @GetMapping("api/users/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("api/users/{id}")
    public ResponseEntity<String> updateUserById(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        UserDTO updateUserById = userService.updateUserById(id, userDTO);
        return ResponseEntity.ok("User updated successfully");
    }

    @DeleteMapping("api/users/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}