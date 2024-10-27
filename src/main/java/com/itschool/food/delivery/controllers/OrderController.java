package com.itschool.food.delivery.controllers;

import com.itschool.food.delivery.models.dtos.OrderDTO;
import com.itschool.food.delivery.models.dtos.RequestOrderDTO;
import com.itschool.food.delivery.models.dtos.ResponseOrderDTO;
import com.itschool.food.delivery.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<ResponseOrderDTO> createOrder(@Valid @RequestBody RequestOrderDTO requestOrderDTO) {
        return ResponseEntity.ok(orderService.createOrder(requestOrderDTO));
    }

    @GetMapping("{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateOrderById(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        OrderDTO updatedOrderById = orderService.updateOrderById(id, orderDTO);
        return ResponseEntity.ok("Updated order");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrderById(@PathVariable Long id) {
        orderService.deleteOrderById(id);
        return ResponseEntity.ok("Order deleted");
    }
}