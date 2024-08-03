package com.gokapture.taskapp.dtos;

import com.gokapture.taskapp.models.Role;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private String name;
    private String email;
    private String username;
    private String password;
    private String phone;
}