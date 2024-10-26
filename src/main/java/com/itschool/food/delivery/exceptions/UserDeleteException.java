package com.itschool.food.delivery.exceptions;

public class UserDeleteException extends RuntimeException {
    public UserDeleteException(String id) {
        super("User with the ID " + id + " not found");
    }
}