package com.itschool.food.delivery.exceptions;

public class OrderCreateException extends RuntimeException {

    public OrderCreateException(String message) {
        super(message);
    }
}