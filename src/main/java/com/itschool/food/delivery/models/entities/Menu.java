package com.itschool.food.delivery.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.awt.*;

@Data
@Entity
@Table(name = "menus")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private double price;

    //@OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    //private List<Menu> menus;
}