package com.itschool.food.delivery.services;

import com.itschool.food.delivery.models.dtos.UserDTO;
import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);
    UserDTO getUserById(Long id);
    UserDTO updateUserById(Long id, UserDTO userDTO);
    void deleteUserById(Long id);
    List<UserDTO> getUsers();
}