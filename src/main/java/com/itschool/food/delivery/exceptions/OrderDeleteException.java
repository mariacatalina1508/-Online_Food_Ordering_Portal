package com.itschool.food.delivery.exceptions;

public class OrderDeleteException extends RuntimeException {
    public OrderDeleteException(String id) {
        super("Order with the ID " + id + " not found");
    }
}