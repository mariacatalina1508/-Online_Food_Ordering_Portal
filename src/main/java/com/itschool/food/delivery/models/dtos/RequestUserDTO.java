package com.itschool.food.delivery.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestUserDTO {

    @NotNull(message = "First name is required")
    @Size(max = 70, message = "First name must be less than 70 characters")
    private String firstName;

    @NotNull(message = "Last name is required")
    @Size(max = 70, message = "Last name must be less than 70 characters")
    private String lastName;

    @NotBlank(message = "This field is mandatory")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email should be valid")
    private String email;

    @NotNull(message = "Phone number is required")
    @Size(min = 10, max = 15, message = "Phone number should be between 10 and 15 characters")
    private String phoneNumber;

    @NotNull(message = "Address is required")
    @Size(max = 90, message = "Address must be less than 90 characters")
    private String address;
}