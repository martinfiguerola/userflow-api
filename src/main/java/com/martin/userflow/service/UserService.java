package com.martin.userflow.service;

import com.martin.userflow.dto.UserRequestDTO;
import com.martin.userflow.dto.UserResponseDTO;

import java.util.List;


public interface UserService {

    UserResponseDTO save (UserRequestDTO userRequestDTO);
    List<UserResponseDTO> findAll ();

}
