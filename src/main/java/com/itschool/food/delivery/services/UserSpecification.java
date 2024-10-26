package com.itschool.food.delivery.services;

import com.itschool.food.delivery.models.entities.User;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {
    // firstName, lastName, phoneNumber, email, address

    public static Specification<User> firstNameContains(String firstName) {
        return (user, query, criteriaBuilder) -> firstName == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(user.get("firstName")), "%" + firstName.toLowerCase() + "%");
    }

    public static Specification<User> lastNameContains(String lastName) {
        return (user, query, criteriaBuilder) -> lastName == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(user.get("lastName")), "%" + lastName.toLowerCase() + "%");
    }

    public static Specification<User> phoneNumberContains(String phoneNumber) {
        return (user, query, criteriaBuilder) -> phoneNumber == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(user.get("phoneNumber")), "%" + phoneNumber.toLowerCase() + "%");
    }

    public static Specification<User> emailContains(String email) {
        return (user, query, criteriaBuilder) -> email == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(user.get("email")), "%" + email.toLowerCase() + "%");
    }
    public static Specification<User> addressContains(String address) {
        return (user, query, criteriaBuilder) -> address == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(user.get("address")), "%" + address.toLowerCase() + "%");
    }
}