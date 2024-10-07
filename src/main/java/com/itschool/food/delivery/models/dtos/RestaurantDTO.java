package com.itschool.food.delivery.models.dtos;

import java.util.List;

public class RestaurantDTO {

    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private double rating;
    private List<MenuDTO> menus;
}