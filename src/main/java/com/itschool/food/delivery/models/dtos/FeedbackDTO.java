package com.itschool.food.delivery.models.dtos;

import java.time.LocalDateTime;

public class FeedbackDTO {

    private Long id;
    private Long userId;
    private Long restaurantId;
    private Long orderId;
    private int rating;
    private String comments;
    private LocalDateTime date;
}