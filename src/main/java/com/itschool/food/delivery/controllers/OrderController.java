package com.itschool.food.delivery.controllers;

import com.itschool.food.delivery.models.dtos.OrderDTO;
import com.itschool.food.delivery.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Endpoint pentru plasarea unei comenzi
    @PostMapping("/place")
    public ResponseEntity<String> placeOrder(@RequestBody OrderDTO orderDTO) {
        orderService.placeOrder(orderDTO);
        return ResponseEntity.ok("Order placed");
    }
    // Endpoint pentru vizualizarea unei comenzi
    @GetMapping("/{orderId")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable String orderId) {
        OrderDTO orderDTO = orderService.getOrderDetails(orderId);
        return ResponseEntity.ok(orderDTO);
    }
    // Endpoint pentru anularea unei comenzi
    @DeleteMapping("/{orderId")
    public ResponseEntity<String> cancelOrder(@PathVariable String orderId) {
        orderService.cancelOrder(orderId);
        return ResponseEntity.ok("Order cancelled successfully");
    }
}