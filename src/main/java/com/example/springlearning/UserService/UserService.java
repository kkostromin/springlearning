package com.example.springlearning.UserService;

import com.example.springlearning.entity.UserEntity;
import com.example.springlearning.exeption.UserAlreadyExistExeption;
import com.example.springlearning.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistExeption {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistExeption("User already exist");
        }
        return userRepo.save(user);
    }
}
