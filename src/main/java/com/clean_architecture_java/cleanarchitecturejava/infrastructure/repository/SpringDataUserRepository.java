package com.clean_architecture_java.cleanarchitecturejava.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clean_architecture_java.cleanarchitecturejava.domain.model.User;

public interface SpringDataUserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
