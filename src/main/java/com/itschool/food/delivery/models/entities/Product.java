package com.itschool.food.delivery.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column private String productName;

    @Column
    private double price;

    @Column
    private String descriptions;

    @ManyToMany
    @Column
    private Restaurant restaurant;
}