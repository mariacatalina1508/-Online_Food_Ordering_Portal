package com.itschool.food.delivery.exceptions;

public class UserCreateException extends RuntimeException {

    public UserCreateException(String message) {
        super(message);
    }
}