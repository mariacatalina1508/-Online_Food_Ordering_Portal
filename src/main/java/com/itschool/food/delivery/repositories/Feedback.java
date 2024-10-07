package com.itschool.food.delivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface Feedback extends JpaRepository<Feedback, Long> {
    Optional<Feedback> findByRestaurantId(Long restaurantId);
}