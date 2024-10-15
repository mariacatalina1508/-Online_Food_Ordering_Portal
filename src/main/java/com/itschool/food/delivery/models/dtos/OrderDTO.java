package com.itschool.food.delivery.models.dtos;

import lombok.Data;

@Data
public class OrderDTO {

    private Long id;
    private Long userId;
    private Double totalPrice;
    private String orderStatus;
    private String orderDate;
    private String deliveryAddress;
}