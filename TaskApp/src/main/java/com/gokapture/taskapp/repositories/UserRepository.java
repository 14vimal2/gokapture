package com.gokapture.taskapp.repositories;

import com.gokapture.taskapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
//    Optional<User> findById(Long id);
//    Optional<User> findByEmailAndPassword(String email, String password);

}
