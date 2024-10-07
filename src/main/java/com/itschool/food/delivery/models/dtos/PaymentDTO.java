package com.itschool.food.delivery.models.dtos;

import java.time.LocalDateTime;

public class PaymentDTO {

    private Long id;
    private Long orderId;
    private String paymentMethod;
    private String status;
    private double amount;
    private LocalDateTime paymentDate;
}