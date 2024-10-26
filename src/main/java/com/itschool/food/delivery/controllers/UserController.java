package com.itschool.food.delivery.controllers;

import com.itschool.food.delivery.models.dtos.RequestUserDTO;
import com.itschool.food.delivery.models.dtos.ResponseUserDTO;
import com.itschool.food.delivery.models.dtos.UserDTO;
import com.itschool.food.delivery.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/users")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<ResponseUserDTO> createUser(@Valid @RequestBody RequestUserDTO requestUserDTO) {
        return ResponseEntity.ok(userService.createUser(requestUserDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseUserDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUserById(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        ResponseUserDTO updateUserById = userService.updateUserById(id, userDTO);
        return ResponseEntity.ok("User updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}