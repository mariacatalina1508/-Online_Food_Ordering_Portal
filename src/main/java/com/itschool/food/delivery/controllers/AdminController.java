package com.itschool.food.delivery.controllers;

import com.itschool.food.delivery.models.dtos.UserDTO;
import com.itschool.food.delivery.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private final AdminService adminService;

    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }
    // Endpoint pentru gestionarea utilizatorilor
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = adminService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Endpoint pentru gestionarea restaurantelor
    @DeleteMapping("/restaurants/{restaurantId}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable String restaurantId) {
        adminService.deleteRestaurant(restaurantId);
        return ResponseEntity.ok("Restaurant deleted successfully");
    }
}