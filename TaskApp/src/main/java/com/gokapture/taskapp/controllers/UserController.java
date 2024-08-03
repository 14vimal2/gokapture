package com.gokapture.taskapp.controllers;

import com.gokapture.taskapp.dtos.UserDto;
import com.gokapture.taskapp.models.User;
import com.gokapture.taskapp.services.UserService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody UserDto userDto) throws Exception {
        if(userDto.getUsername() == null || userDto.getPassword() == null) {
            throw new BadRequestException("Username and password are required");
        }
        return userService.createUser(userDto);
    }

}