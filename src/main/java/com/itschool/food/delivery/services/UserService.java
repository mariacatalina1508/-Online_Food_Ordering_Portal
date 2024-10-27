package com.itschool.food.delivery.services;

import com.itschool.food.delivery.models.dtos.RequestUserDTO;
import com.itschool.food.delivery.models.dtos.ResponseUserDTO;
import com.itschool.food.delivery.models.dtos.UserDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UserService {

    UserDTO getUserById(Long id);

    ResponseUserDTO createUser(RequestUserDTO requestUserDTO);

    List<UserDTO> getUsers();

    UserDTO updateUserById(Long id, UserDTO userDTO);
    List<ResponseUserDTO> getFilteredUsers(String firstName, String lastName, String phoneNumber, String email, String address);

    void deleteUserById(Long id);
}