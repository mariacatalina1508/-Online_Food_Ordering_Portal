package com.itschool.food.delivery.models.dtos;

import lombok.Data;

@Data
public class MenuDTO {
    private Long id;
    private String name;
    private String description;
    private Long price;
}