package com.clean_architecture_java.cleanarchitecturejava.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clean_architecture_java.cleanarchitecturejava.domain.model.User;
import com.clean_architecture_java.cleanarchitecturejava.domain.repository.UserRepository;

@Repository
public class JpaUserRepository implements UserRepository {
    @Autowired
    private final SpringDataUserRepository springDataUserRepository;

    public JpaUserRepository(SpringDataUserRepository springDataUserRepository) {
        this.springDataUserRepository = springDataUserRepository;
    }
    
    @Override
    public User getById(Long id) {
        return springDataUserRepository.findById(id)
            .orElseThrow(() ->  new RuntimeException("User not found"));
    }

    @Override
    public void create(User user) {
        springDataUserRepository.save(user);
    }

    @Override
    public User getByEmail(String email) {
        return springDataUserRepository.findByEmail(email);
    }

    @Override
    public User update(User user) {
        User userEntity = springDataUserRepository.save(user);
        return userEntity;
    }

    @Override
    public String delete(User entity) {
        
        springDataUserRepository.delete(entity);

        return "User deleted";
    }

}
