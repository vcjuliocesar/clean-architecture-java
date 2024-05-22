package com.clean_architecture_java.cleanarchitecturejava.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clean_architecture_java.cleanarchitecturejava.application.usecase.CreateUserUseCase;
import com.clean_architecture_java.cleanarchitecturejava.application.usecase.DeleteUserUseCase;
import com.clean_architecture_java.cleanarchitecturejava.application.usecase.GetUserUseCase;
import com.clean_architecture_java.cleanarchitecturejava.application.usecase.UpdateUserUseCase;
import com.clean_architecture_java.cleanarchitecturejava.domain.model.User;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private final GetUserUseCase getUserUseCase;
    
    @Autowired
    private final CreateUserUseCase createUserUseCase;

    @Autowired
    private final UpdateUserUseCase updateUserUseCase;

    @Autowired
    private final DeleteUserUseCase deleteUserUseCase;

    public UserController(GetUserUseCase getUserUseCase,CreateUserUseCase createUserUseCase,UpdateUserUseCase updateUserUseCase,DeleteUserUseCase deleteUserUseCase){
        this.getUserUseCase = getUserUseCase;
        this.createUserUseCase = createUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
    }
    
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return this.getUserUseCase.execute(id);
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        
        this.createUserUseCase.execute(user);
    }
    
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User entity) {
        
        return this.updateUserUseCase.execute(id, entity);
    }
    
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){

        return this.deleteUserUseCase.execute(id);
    }
}

