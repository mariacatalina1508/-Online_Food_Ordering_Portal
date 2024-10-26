package com.itschool.food.delivery.exceptions;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String id) {
        super("Order with ID " + id + " not found");
    }
}