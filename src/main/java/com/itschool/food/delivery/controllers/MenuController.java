package com.itschool.food.delivery.controllers;

import com.itschool.food.delivery.models.dtos.*;
import com.itschool.food.delivery.services.MenuService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/menus")
@RestController
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping
    public ResponseEntity<ResponseMenuDTO> createMenu(@Valid @RequestBody RequestMenuDTO requestMenuDTO) {
        return ResponseEntity.ok(menuService.createMenu(requestMenuDTO));
    }

    @GetMapping("{id}")
    public ResponseEntity<MenuDTO> getMenuById(@PathVariable Long id) {
        return ResponseEntity.ok(menuService.getMenuById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateMenuById(@PathVariable Long id, @RequestBody MenuDTO menuDTO) {
        MenuDTO updatedMenuById = menuService.updateMenuById(id, menuDTO);
        return ResponseEntity.ok("Updated menu");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMenuById(@PathVariable Long id) {
        menuService.deleteMenuById(id);
        return ResponseEntity.ok("Menu deleted");
    }
}