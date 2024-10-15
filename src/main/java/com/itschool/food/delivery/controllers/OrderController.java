package com.itschool.food.delivery.controllers;

import com.itschool.food.delivery.models.dtos.OrderDTO;
import com.itschool.food.delivery.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/api/orders")
    public ResponseEntity<OrderDTO> createUser(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.createOrder(orderDTO));
    }

    @GetMapping("/api/orders/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @PutMapping("/api/orders/{id}")
    public ResponseEntity<String> updateOrderById(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        OrderDTO updateOrderById = orderService.updateOrderById(id, orderDTO);
        return ResponseEntity.ok("Order updated successfully");
    }

    @DeleteMapping("/api/orders/{id}")
    public ResponseEntity<String> deleteOrderById(@PathVariable Long id) {
        orderService.deleteOrderById(id);
        return ResponseEntity.ok("Order deleted successfully");
    }
}