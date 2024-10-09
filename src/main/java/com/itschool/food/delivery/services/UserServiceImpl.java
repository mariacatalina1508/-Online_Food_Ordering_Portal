package com.itschool.food.delivery.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.food.delivery.models.dtos.UserDTO;
import com.itschool.food.delivery.models.entities.User;
import com.itschool.food.delivery.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
        User UserEntity = objectMapper.convertValue(UserDTO, User.class);
        User userEntityResponse = userRepository.save(UserEntity);
        log.info("User with id {} was saved", userEntityResponse.getId());
        return objectMapper.convertValue(userEntityResponse, UserDTO.class);
    }
}