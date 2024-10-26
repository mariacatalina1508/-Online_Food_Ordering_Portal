package com.itschool.food.delivery.exceptions;

public class MenuDeleteException extends RuntimeException {
    public MenuDeleteException(String id) {
        super("Menu with the ID " + id + " not found");
    }
}