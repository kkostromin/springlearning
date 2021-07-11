package com.example.springlearning.UserService;

import com.example.springlearning.entity.UserEntity;
import com.example.springlearning.exeption.UserAlreadyExistExeption;
import com.example.springlearning.exeption.UserNotFoundExeption;
import com.example.springlearning.model.User;
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

    public User getOne(Long id) throws UserNotFoundExeption {
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundExeption("User not found");
        }
        return User.toModel(user);

    }
}
