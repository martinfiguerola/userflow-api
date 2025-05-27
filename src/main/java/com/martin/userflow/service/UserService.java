package com.martin.userflow.service;

import com.martin.userflow.dto.UserRequestDTO;
import com.martin.userflow.dto.UserResponseDTO;

import java.util.List;
import java.util.Optional;


public interface UserService {

    UserResponseDTO save (UserRequestDTO userRequestDTO);
    List<UserResponseDTO> findAll ();
    Optional<UserResponseDTO> update (Long id, UserRequestDTO userRequestDTO);
    Boolean deleteById (Long id);

}
