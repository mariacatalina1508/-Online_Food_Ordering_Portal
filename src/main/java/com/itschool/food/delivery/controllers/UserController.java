package com.itschool.food.delivery.controllers;

import com.itschool.food.delivery.models.dtos.RequestUserDTO;
import com.itschool.food.delivery.models.dtos.ResponseUserDTO;
import com.itschool.food.delivery.models.dtos.UserDTO;
import com.itschool.food.delivery.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<ResponseUserDTO>> getFilteredUsers(
            @RequestParam(value = "first_name", required = false) String first_name,
            @RequestParam(value = "last_name", required = false) String last_name,
            @RequestParam(value = "phone_number", required = false) String phone_number,
            @RequestParam(value = "address", required = false) String address,
            @RequestParam(value = "email", required = false) String email) {

        return ResponseEntity.ok(userService.getFilteredUsers(first_name, last_name, phone_number, email, address));
    }


    @PutMapping("{id}")
    public ResponseEntity<String> updateUserById(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        UserDTO updateUserById = userService.updateUserById(id, userDTO);
        return ResponseEntity.ok("Updated user");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok("User deleted");
    }
}