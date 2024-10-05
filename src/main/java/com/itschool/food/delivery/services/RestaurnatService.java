package com.itschool.food.delivery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurants")
public class RestaurnatService {

    @Autowired
    private RestaurnatService restaurnatService;

    @PostMapping("/add")
    public ResponseEntity<String> addRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        restaurnatService.addRestaurant(restaurantDTO);
        return ResponseEntity.ok("Restaurant added successfully");
    }
    @GetMapping("/{restaurantId}/menu")
    public ResponseEntity<MenuDTO> getRestaurantMenu(@PathVariable String restaurantId) {
        MenuDTO menuDTO = restaurnatService.getMenu(restaurantId);
        return ResponseEntity.ok(menuDTO);
    }
    @PutMapping("/{restaurantId}/menu")
    public ResponseEntity<String> updateMenu(@PathVariable String restaurantId, @RequestBody MenuDTO menuDTO) {
        restaurnatService.updateMenu(restaurantId, menuDTO);
        return ResponseEntity.ok("Menu update successfully");
    }
}