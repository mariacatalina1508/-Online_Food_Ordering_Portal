package com.itschool.food.delivery.models.dtos;

import java.util.List;

public class MenuDTO {

    private Long id;
    private Long restaurantId;
    private String name;
    private List<MenuItemDTO> items;
}