package com.itschool.food.delivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface Payment extends JpaRepository<Payment, Long> {
    Optional<Payment>findByOrderId(Long orderId);
}