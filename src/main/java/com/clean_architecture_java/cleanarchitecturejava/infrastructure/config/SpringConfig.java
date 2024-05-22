package com.clean_architecture_java.cleanarchitecturejava.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.clean_architecture_java.cleanarchitecturejava.application.service.UserService;
import com.clean_architecture_java.cleanarchitecturejava.domain.repository.UserRepository;

@Configuration
public class SpringConfig{

    @Bean
    public UserService userService(UserRepository userRepository,PasswordEncoder passwordEncoder) {
        return new UserService(userRepository,passwordEncoder);
    }
}
