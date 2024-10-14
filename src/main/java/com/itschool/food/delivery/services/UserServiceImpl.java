package com.itschool.food.delivery.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.food.delivery.exceptions.UserCreateException;
import com.itschool.food.delivery.models.dtos.UserDTO;
import com.itschool.food.delivery.models.entities.User;
import com.itschool.food.delivery.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final ObjectMapper objectMapper;
    public final UserRepository userRepository;

    public UserServiceImpl(ObjectMapper objectMapper, UserRepository userRepository) {
        this.objectMapper = objectMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User UserEntity = objectMapper.convertValue(userDTO, User.class);
        User userEntityResponse = userRepository.save(UserEntity);
        log.info("User with id {} was saved", userEntityResponse.getId());
        return objectMapper.convertValue(userEntityResponse, UserDTO.class);
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(user -> objectMapper.convertValue(user, UserDTO.class))
                .orElseThrow(() -> new UserCreateException("User with the ID" + id + "not found"));
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> objectMapper.convertValue(user, UserDTO.class))
                .toList();
    }

    @Override
    public UserDTO updateUserById(Long id, UserDTO userDTO) {
        if (userDTO == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setFirstName(userDTO.getFirstName() != null ? userDTO.getFirstName() : existingUser.getFirstName());
            existingUser.setLastName(userDTO.getLastName() != null ? userDTO.getLastName() : existingUser.getLastName());
            existingUser.setAddress(userDTO.getAddress() != null ? userDTO.getAddress() : existingUser.getAddress());
            existingUser.setPhoneNumber(userDTO.getPhoneNumber() != null ? userDTO.getPhoneNumber() : existingUser.getPhoneNumber());
            existingUser.setEmail(userDTO.getEmail() != null ? userDTO.getEmail() : existingUser.getPhoneNumber());

            User updateUser = userRepository.save(existingUser);
            log.info("Received UserDTO: {}", userDTO);

            return objectMapper.convertValue(updateUser, UserDTO.class);
        }).orElseThrow(() -> new UserCreateException("User with the ID" + id + "not found"));
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}