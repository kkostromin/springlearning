package com.example.springlearning.exeption;

public class UserNotFoundExeption extends Exception{

    public UserNotFoundExeption(String message) {
        super(message);
    }
}
