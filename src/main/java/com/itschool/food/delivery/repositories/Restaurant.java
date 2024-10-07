package com.itschool.food.delivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface Restaurant extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findByCity(String City);
    Optional<Restaurant> findByName(String name);
}