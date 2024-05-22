package com.clean_architecture_java.cleanarchitecturejava.application.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clean_architecture_java.cleanarchitecturejava.application.service.UserService;

@Component
public class DeleteUserUseCase {
    @Autowired
    private final UserService userService;

    public DeleteUserUseCase(UserService userService){
        this.userService = userService;
    }

    public String execute(Long id){
        return this.userService.deleteUser(id);
    }

}
