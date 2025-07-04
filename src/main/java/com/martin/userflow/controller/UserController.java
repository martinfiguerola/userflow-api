package com.martin.userflow.controller;

import com.martin.userflow.dto.UserRequestDTO;
import com.martin.userflow.dto.UserResponseDTO;
import com.martin.userflow.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser ( @Valid @RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO response = userService.save(userRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers () {
        List<UserResponseDTO> response = userService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser (@PathVariable Long id, @Valid @RequestBody UserRequestDTO userRequestDTO) {
         return userService.update(id, userRequestDTO)
                 .map( userResponseDTO -> ResponseEntity.status(HttpStatus.OK).body(userResponseDTO))
                 .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser (@PathVariable Long id) {
        if (userService.deleteById(id)) return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with the given ID does not exist.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getOneUser (@PathVariable Long id) {
        return userService.findById(id)
                .map( user -> ResponseEntity.status(HttpStatus.OK).body(user))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
