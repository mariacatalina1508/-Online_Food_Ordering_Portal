package com.itschool.food.delivery.repositories;

import com.itschool.food.delivery.models.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}