package com.martin.userflow.service;

import com.martin.userflow.dto.UserRequestDTO;
import com.martin.userflow.dto.UserResponseDTO;
import com.martin.userflow.entity.User;
import com.martin.userflow.mapper.UserMapper;
import com.martin.userflow.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDTO save(UserRequestDTO userRequestDTO) {
        // userRequestDTO { name: pedro, email: pedro@mail.com, password: 1234}

        // Step 1: Convert the incoming DTO to a domain entity
        User user = UserMapper.fromDTO(userRequestDTO);

        // Step 2: Persist the user entity in the database
        User savedUser = userRepository.save(user);

        // Step 3: Convert the saved User entity to a response DTO
        UserResponseDTO responseDTO = UserMapper.toDTO(savedUser);

        // Step 4: Return to the client
        return responseDTO;

    }
}
