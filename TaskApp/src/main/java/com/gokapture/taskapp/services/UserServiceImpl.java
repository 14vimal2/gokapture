package com.gokapture.taskapp.services;

import com.gokapture.taskapp.dtos.UserDto;
import com.gokapture.taskapp.exceptions.UserAlreadyExistsException;
import com.gokapture.taskapp.exceptions.UserNotFoundException;
import com.gokapture.taskapp.models.Role;
import com.gokapture.taskapp.models.User;
import com.gokapture.taskapp.repositories.RoleRepository;
import com.gokapture.taskapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(
            BCryptPasswordEncoder bCryptPasswordEncoder,
            UserRepository userRepository,
            RoleRepository roleRepository
    ) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }



    @Override
    public User createUser(UserDto userDto) throws UserAlreadyExistsException, RoleNotFoundException {

        Optional<User> userOptional = userRepository.findByUsername(userDto.getUsername());
        if (userOptional.isPresent()) {
            throw new UserAlreadyExistsException(userDto.getUsername());
        }

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        Optional<Role> roleOptional = roleRepository.findByName("USER");
        if (roleOptional.isEmpty()) {
            throw new RoleNotFoundException("ROLE_USER");
        }
        Role role = roleOptional.get();
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);

        user.setPhone(userDto.getPhone());

        user.setHashedPassword( bCryptPasswordEncoder.encode(userDto.getPassword()));

        return userRepository.save(user);

    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        throw new UserNotFoundException("no user found with id: " + id);
    }

    @Override
    public User getUserByEmail(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        throw new UserNotFoundException("no user found with email: " + email);
    }

    @Override
    public User getUserByUsername(String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        throw new UserNotFoundException("no user found with username: " + username);
    }
}
