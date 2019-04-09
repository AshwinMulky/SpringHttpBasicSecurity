package com.ashwinmulky.spring.security.repository;

import com.ashwinmulky.spring.security.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByName(String name);
}
