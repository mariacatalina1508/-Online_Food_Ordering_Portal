package com.itschool.food.delivery.controllers;

import com.itschool.food.delivery.models.dtos.MenuDTO;
import com.itschool.food.delivery.services.MenuService;
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
    public ResponseEntity<MenuDTO> createMenu(@RequestBody MenuDTO menuDTO) {
        return ResponseEntity.ok(menuService.createMenu(menuDTO));
    }
    @GetMapping("/{id}")
    public ResponseEntity<MenuDTO> getMenuById(@PathVariable Long id) {
        return ResponseEntity.ok(menuService.getMenuById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateMenuById(@PathVariable Long id, @RequestBody MenuDTO menuDTO) {
        MenuDTO updateMenuById = menuService.updateMenuById(id, menuDTO);
        return ResponseEntity.ok("Menu updated successfully");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMenuById(@PathVariable Long id) {
        menuService.deleteMenuById(id);
        return ResponseEntity.ok("Menu deleted successfully");
    }
}