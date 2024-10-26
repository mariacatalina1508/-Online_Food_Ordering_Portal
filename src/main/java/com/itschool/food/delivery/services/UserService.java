package com.itschool.food.delivery.services;

import com.itschool.food.delivery.models.dtos.RequestUserDTO;
import com.itschool.food.delivery.models.dtos.ResponseUserDTO;
import com.itschool.food.delivery.models.dtos.UserDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UserService {

    ResponseUserDTO createUser(RequestUserDTO userDTO);
    ResponseUserDTO getUserById(Long id);
    ResponseUserDTO updateUserById(Long id, UserDTO userDTO);
    void deleteUserById(Long id);
    List<UserDTO> getUsers();
    List<ResponseUserDTO> getFilteredOwners(String firstName, String lastName, String phoneNumber, String email);
}