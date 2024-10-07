package com.itschool.food.delivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface Admin extends JpaRepository<Admin, Long> {
    Optional<Admin> findByUsername(String username);
}