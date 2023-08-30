package com.example.bankapp.service.exception;

public class ManagerNotFoundException extends RuntimeException{
    public ManagerNotFoundException (String massage){
        super (massage);
    }
}
