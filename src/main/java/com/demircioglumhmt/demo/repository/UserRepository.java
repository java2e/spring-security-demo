package com.demircioglumhmt.demo.repository;

import com.demircioglumhmt.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);

    <T> Optional<T> findById(Long id);

    User save(User user);
}
