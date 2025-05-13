package com.martin.userflow.service;

import com.martin.userflow.dto.UserRequestDTO;
import com.martin.userflow.dto.UserResponseDTO;


public interface UserService {

    UserResponseDTO save (UserRequestDTO userRequestDTO);

}
