package com.example.designpatterns.bookmyshow.controller;

import com.example.designpatterns.bookmyshow.model.dto.UserDto;
import com.example.designpatterns.bookmyshow.model.entity.User;
import com.example.designpatterns.bookmyshow.service.UserService;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(final @RequestBody @Valid UserDto userDto) {
        final UserDto user = userService.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(user);
    }

    @PostMapping("/update")
    public String updateUser(final @RequestBody User user) {
        return userService.updateUser(user);
    }
}
