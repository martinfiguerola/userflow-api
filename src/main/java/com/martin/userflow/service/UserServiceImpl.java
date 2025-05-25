package com.martin.userflow.service;

import com.martin.userflow.dto.UserRequestDTO;
import com.martin.userflow.dto.UserResponseDTO;
import com.martin.userflow.entity.User;
import com.martin.userflow.mapper.UserMapper;
import com.martin.userflow.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<UserResponseDTO> findAll() {
        // Step 1: Retrieve all User entities from the database
        List<User> users = userRepository.findAll();

        // Step 2: Map each User entity to a UserResponseDTO
        List<UserResponseDTO> userResponseDTOList = users.stream()
                .map(UserMapper::toDTO)
                .toList();

        // Step 3: Return the list of UserResponseDTOs
        return userResponseDTOList;
    }

    @Override
    public Optional<UserResponseDTO> update(Long id, UserRequestDTO userRequestDTO) {

        // Step 1: Find the user by ID. If not found, the Optional will be empty.
        Optional<User> optionalUser = userRepository.findById(id);

        // Step 2: If the user exists, update, save, convert, and return an Optional with your DTO;
        // otherwise, return an empty Optional.
        return optionalUser.map(existUser -> {
            // Update the user fields with the data from the request
            existUser.setName(userRequestDTO.getName());
            existUser.setEmail(userRequestDTO.getEmail());
            existUser.setPassword(userRequestDTO.getPassword());

            // Save the updated user
            User savedUser = userRepository.save(existUser);

            // Convert the saved and saved entity to a DTO and return it
            return UserMapper.toDTO(savedUser);

        });

    }
}
