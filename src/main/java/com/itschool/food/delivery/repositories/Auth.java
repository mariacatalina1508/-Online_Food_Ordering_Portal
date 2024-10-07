package com.itschool.food.delivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface Auth extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}