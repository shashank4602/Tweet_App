package com.radi.endtoend.tweeter.repository;

import com.radi.endtoend.tweeter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findById(Integer integer);
    User findByUsername(String name);
    User save(User user);
}
