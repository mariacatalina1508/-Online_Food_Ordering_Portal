package com.itschool.food.delivery.models.dtos;

import lombok.Data;

@Data
public class ResponseMenuDTO {

    private Long id;

    private String name;

    private String description;

    private Double price;
}