package com.itschool.food.delivery.controllers;

import com.itschool.food.delivery.models.dtos.RequestOrderDTO;
import com.itschool.food.delivery.models.dtos.ResponseOrderDTO;
import com.itschool.food.delivery.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping
@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<ResponseOrderDTO> createOrder(@RequestBody RequestOrderDTO requestOrderDTO) {
        return ResponseEntity.ok(orderService.createOrder(requestOrderDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseOrderDTO> updateOrder(@PathVariable Long id,@RequestBody RequestOrderDTO requestOrderDTO){
        return ResponseEntity.ok(orderService.updateOrder(id, requestOrderDTO.getOrders()));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<ResponseOrderDTO>> getOrders(
            @RequestParam(value = "address", required = false) String address,
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "date", required = false) String date) {
        return ResponseEntity.ok(orderService.getOrders(address, status, date));
    }
}