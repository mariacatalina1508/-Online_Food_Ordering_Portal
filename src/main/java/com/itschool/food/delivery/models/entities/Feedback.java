package com.itschool.food.delivery.models.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "feedback")
public class Feedback {

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
    private int rating;

    @Column
    private String comment;

    @Column
    private LocalDateTime feedbackDate;
}