package com.clean_architecture_java.cleanarchitecturejava.application.service;

import org.springframework.stereotype.Service;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.clean_architecture_java.cleanarchitecturejava.domain.model.User;
import com.clean_architecture_java.cleanarchitecturejava.domain.repository.UserRepository;
@Service
public class UserService {

     private final UserRepository userRepository;
     private final PasswordEncoder passwordEncoder;

     public UserService(UserRepository userRepository,PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
     }

     public User getUserById(Long id){
        return this.userRepository.getById(id);
     }

     public void creatUser(User user){
         
         String hashedPassword = this.passwordEncoder.encode(user.getPassword());
         user.setPassword(hashedPassword);
         
         User existingUser = this.userRepository.getByEmail(user.getEmail());

         if(existingUser != null){
            throw new RuntimeException("User "+user.getEmail()+" already exists");
         }

         this.userRepository.create(user);
     }

     public User updateUser(Long id, User user){
         User existingUser = this.userRepository.getById(id);

         if(existingUser == null){
            throw new RuntimeException("User "+user.getEmail()+" no exists");
         }

         existingUser.setName(user.getName());
         existingUser.setEmail(user.getEmail());
         existingUser.setPhone(user.getPhone());
         existingUser.setPassword(user.getPassword());
         

         return this.userRepository.update(existingUser);
     }

   @SuppressWarnings("null")
   public String deleteUser(Long id){
      User user = this.userRepository.getById(id);

         if(user == null){
            throw new RuntimeException("User "+user.getEmail()+" no exists");
         }
         this.userRepository.delete(user);
         return "User deleted";
     }
}
