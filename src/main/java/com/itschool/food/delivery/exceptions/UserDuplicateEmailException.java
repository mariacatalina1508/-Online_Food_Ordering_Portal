package com.itschool.food.delivery.exceptions;

public class UserDuplicateEmailException extends RuntimeException {
    public UserDuplicateEmailException(String message) {
        super(message);
    }
}