package com.itschool.food.delivery.models.dtos;

import lombok.Data;

@Data
public class RequestOrderDTO {

    private String name;

    private String description;

    private Double price;
}