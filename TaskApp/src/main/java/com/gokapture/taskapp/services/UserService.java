package com.gokapture.taskapp.services;

import com.gokapture.taskapp.dtos.UserDto;
import com.gokapture.taskapp.exceptions.UserAlreadyExistsException;
import com.gokapture.taskapp.models.User;

import javax.management.relation.RoleNotFoundException;

public interface UserService {

    User createUser(UserDto userDto) throws UserAlreadyExistsException, RoleNotFoundException;

    User updateUser(User user);
    User getUserById(Long id);
    User getUserByEmail(String email);
    User getUserByUsername(String username);
}
