package com.itschool.food.delivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface Order extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);
    List<Order> findByRestaurantId(Long restaurantId);
}