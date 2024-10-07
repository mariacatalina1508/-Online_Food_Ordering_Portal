package com.itschool.food.delivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface Menu extends JpaRepository<Menu, Long> {
    List<Menu> findByRestaurantId(Long restaurantId);
}