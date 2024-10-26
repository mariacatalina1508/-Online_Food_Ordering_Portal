package com.itschool.food.delivery.exceptions;

public class MenuNotFoundException extends RuntimeException {
    public MenuNotFoundException(String id) {
        super("Menu with the ID " + id + " not found");
    }
}