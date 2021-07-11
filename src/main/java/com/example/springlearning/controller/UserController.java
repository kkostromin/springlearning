package com.example.springlearning.controller;

import com.example.springlearning.UserService.UserService;
import com.example.springlearning.entity.UserEntity;
import com.example.springlearning.exeption.UserAlreadyExistExeption;
import com.example.springlearning.exeption.UserNotFoundExeption;
import com.example.springlearning.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("User save");
        } catch (UserAlreadyExistExeption e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userService.getOne(id));
        }
        catch (UserNotFoundExeption e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }

    }
}
