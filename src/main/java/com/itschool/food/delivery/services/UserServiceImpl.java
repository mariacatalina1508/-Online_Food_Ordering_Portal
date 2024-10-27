package com.itschool.food.delivery.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.food.delivery.exceptions.UserCreateException;
import com.itschool.food.delivery.exceptions.UserDuplicateEmailException;
import com.itschool.food.delivery.exceptions.UserNotFoundException;
import com.itschool.food.delivery.models.dtos.RequestUserDTO;
import com.itschool.food.delivery.models.dtos.ResponseUserDTO;
import com.itschool.food.delivery.models.dtos.UserDTO;
import com.itschool.food.delivery.models.entities.User;
import com.itschool.food.delivery.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final ObjectMapper objectMapper;

    private final UserRepository userRepository;

    public UserServiceImpl(ObjectMapper objectMapper, UserRepository userRepository) {
        this.objectMapper = objectMapper;
        this.userRepository = userRepository;
    }
    @Override
    public ResponseUserDTO createUser(RequestUserDTO requestUserDTO) {
        User userEntity = objectMapper.convertValue(requestUserDTO, User.class);
        User userEntityResponse = userRepository.save(userEntity);
        log.info("User with id {} was saved", userEntityResponse.getId());

        return objectMapper.convertValue(userEntityResponse, ResponseUserDTO.class);
    }
    @Override
    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> objectMapper.convertValue(user, UserDTO.class))
                .toList();
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(user -> objectMapper.convertValue(user, UserDTO.class))
                .orElseThrow(() -> new UserNotFoundException("User with ID" + id + "not found"));
    }
    @Override
    public List<ResponseUserDTO> getFilteredUsers(String firstName, String lastName, String phoneNumber, String email, String address) {
        Specification<User> spec = Specification
                .where(UserSpecification.firstNameContains(firstName))
                .and(UserSpecification.lastNameContains(lastName))
                .and(UserSpecification.addressContains(address))
                .and(UserSpecification.phoneNumberContains(phoneNumber))
                .and(UserSpecification.emailContains(email));

        List<User> users = userRepository.findAll(spec);
        log.info("{} users found", users.size());

        return users.stream()
                .map(user -> objectMapper.convertValue(user, ResponseUserDTO.class))
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
            existingUser.setEmail(userDTO.getEmail() != null ? userDTO.getEmail() : existingUser.getEmail());

            User updateUser = userRepository.save(existingUser);
            log.info("Received UserDTO: {}", userDTO);

            return objectMapper.convertValue(updateUser, UserDTO.class);
        }).orElseThrow(() -> new UserCreateException("User with the ID" + id + "not found"));
    }
    @Override
    public void deleteUserById(Long id) {
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with the id " + id + "not found"));
        userRepository.deleteById(id);
        log.info("User with the id {} was deleted", id);
    }
    private void validateEmailAddress(RequestUserDTO requestUserDTO) {
        User user = userRepository.findByEmail(requestUserDTO.getEmail());
        if (user != null) {
            throw new UserDuplicateEmailException("The email address already exists");
        }
    }
}