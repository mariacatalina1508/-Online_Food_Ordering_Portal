package com.itschool.food.delivery.models.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinColumn
    private User user;

    @ManyToMany
    @JoinColumn
    private Restaurant restaurant;

    @Column
    private double totalAmount;

    @Column
    private String status;

    @Column
    private LocalDateTime orderDate;
}