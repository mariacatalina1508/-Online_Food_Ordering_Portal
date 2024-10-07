package com.itschool.food.delivery.models.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinColumn
    private Order order;

    @Column
    private double amount;

    @Column
    private LocalDateTime paymentDate;

    @Column
    private String status;
}