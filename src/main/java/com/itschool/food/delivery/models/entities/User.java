package com.itschool.food.delivery.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.awt.*;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "address")
    private String address;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "email")
    private String email;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<User> users;
}