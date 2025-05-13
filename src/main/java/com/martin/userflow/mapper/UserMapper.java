package com.martin.userflow.mapper;

import com.martin.userflow.dto.UserRequestDTO;
import com.martin.userflow.dto.UserResponseDTO;
import com.martin.userflow.entity.User;

public class UserMapper {

    // Using static methods in UserMapper provides convenience and flexibility,
    // allowing you to call the methods without needing to instantiate the class.

    // Convert UserRequestDTO to User entity (for saving to DB)
    // The DTO is part of the presentation layer; we convert it to an entity to apply business logic and save it
    public static User fromDTO (UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());

        return user;
    }

    // Convert User entity to UserResponseDTO (for sending to client)
    public static UserResponseDTO toDTO (User user) {
        UserResponseDTO responseDTO = new UserResponseDTO();

        responseDTO.setId(user.getId());
        responseDTO.setName(user.getName());
        responseDTO.setEmail(user.getEmail());

        return responseDTO;
    }



}
