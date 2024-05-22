package com.clean_architecture_java.cleanarchitecturejava.application.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clean_architecture_java.cleanarchitecturejava.application.service.UserService;
import com.clean_architecture_java.cleanarchitecturejava.domain.model.User;

@Component
public class CreateUserUseCase {
    @Autowired
    private final UserService userService;

    public CreateUserUseCase(UserService userService){
        this.userService = userService;
    }

    public void execute(User user){
        this.userService.creatUser(user);
    }
}
