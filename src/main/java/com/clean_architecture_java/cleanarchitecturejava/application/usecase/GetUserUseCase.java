package com.clean_architecture_java.cleanarchitecturejava.application.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clean_architecture_java.cleanarchitecturejava.application.service.UserService;
import com.clean_architecture_java.cleanarchitecturejava.domain.model.User;

@Component
public class GetUserUseCase {
    @Autowired
    private final UserService userService;

    public GetUserUseCase(UserService usersService){
        this.userService = usersService;
    }

    public User execute(Long id){
        return this.userService.getUserById(id);
    }

}
