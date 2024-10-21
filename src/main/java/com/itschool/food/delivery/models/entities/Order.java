package com.itschool.food.delivery.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "total_price")
    private Double totalPrice;
    @Column(name = "order_status")
    private String orderStatus;
    @Column(name = "order_date")
    private String orderDate;
    @Column(name = "delivery_address")
    private String deliveryAddress;
}