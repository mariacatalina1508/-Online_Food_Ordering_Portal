package com.itschool.food.delivery.models.dtos;

public class OrderDTO {

    private String orderId;
    private String restaurantName;
    private double totalAmount;
    private String status;

    public OrderDTO(String orderId, String restaurantName, double totalAmount, String status) {
        this.orderId = orderId;
        this.restaurantName = restaurantName;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}