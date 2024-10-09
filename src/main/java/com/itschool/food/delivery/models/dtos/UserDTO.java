package com.itschool.food.delivery.models.dtos;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
}