package com.itschool.food.delivery.repositories;

import com.itschool.food.delivery.models.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long {
}