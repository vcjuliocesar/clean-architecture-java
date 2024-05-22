package com.clean_architecture_java.cleanarchitecturejava.domain.repository;

import com.clean_architecture_java.cleanarchitecturejava.domain.model.User;

public interface UserRepository {
    User getById(Long id);
    User getByEmail(String email);
    void create(User user);
    User update(User user);
    String delete(User user);
}
