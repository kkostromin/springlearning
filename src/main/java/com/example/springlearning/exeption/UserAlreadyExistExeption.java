package com.example.springlearning.exeption;

public class UserAlreadyExistExeption extends Exception {
    public UserAlreadyExistExeption(String message) {
        super(message);
    }
}
