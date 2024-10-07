package com.itschool.food.delivery.controllers;

import com.itschool.food.delivery.models.dtos.PaymentDTO;
import com.itschool.food.delivery.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // Endpoint pentru procesarea unei plăți
    @PostMapping("/process")
    public ResponseEntity<String> processPayment(@RequestBody PaymentDTO paymentDTO) {
        paymentService.processPayment(paymentDTO);
        return ResponseEntity.ok("Payment processed successfully");
    }
    // Endpoint pentru vizualizarea detaliilor unei plăți
    @GetMapping("/{paymentId}")
    public ResponseEntity<PaymentDTO> getPaymentDetails(@PathVariable String paymentId) {
        PaymentDTO paymentDTO = paymentService.getPaymentDetails(paymentId);
        return ResponseEntity.ok(paymentDTO);
    }
}