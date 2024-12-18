package com.itschool.food.delivery.models.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestOrderDTO {

    @NotNull(message = "The owner id is required")
    private Long Id;

    @NotNull(message = "Name is required")
    @Size(max = 70, message = "Name must be less than 70 characters")
    private String Name;

    private String description;

    private Double price;

    @NotNull(message = "The status is required")
    @Pattern(regexp = "Pending|Completed|Rejected", message = "Invalid status value")
    private String status;
}