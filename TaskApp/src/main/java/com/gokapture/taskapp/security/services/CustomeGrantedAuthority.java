package com.gokapture.taskapp.security.services;

import com.gokapture.taskapp.models.Role;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@JsonDeserialize
public class CustomeGrantedAuthority implements GrantedAuthority {


    private String authority;

    public CustomeGrantedAuthority( ) {}

    public CustomeGrantedAuthority(Role role) {
        this.authority = role.getName();
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
