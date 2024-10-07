package com.itschool.food.delivery.controllers;

import com.itschool.food.delivery.models.dtos.MenuDTO;
import com.itschool.food.delivery.models.dtos.RestaurantDTO;
import com.itschool.food.delivery.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private final RestaurantService restaurantService;

    public RestController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    // Endpoint pentru adăugarea unui restaurant nou
    @PostMapping("/add")
    public ResponseEntity<String> addRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        restaurantService.addRestaurant(restaurantDTO);
        return ResponseEntity.ok("Restaurant added successfully");
    }
    // Endpoint pentru vizualizarea meniului unui restaurant
    @GetMapping("/{restaurantId}/menu")
    public ResponseEntity<MenuDTO> getRestaurantMenu(@PathVariable String restaurantId) {
        MenuDTO menuDTO = restaurantService.getMenu(restaurantId);
        return ResponseEntity.ok(menuDTO);
    }
    // Endpoint pentru actualizarea meniului unui restaurant
    @PutMapping("/{restaurantId}/menu")
    public ResponseEntity<String> updateMenu(@PathVariable String restaurantId, @RequestBody MenuDTO menuDTO) {
        restaurantService.updateMenu(restaurantId, menuDTO);
        return ResponseEntity.ok("Menu updated successfully");
    }
}