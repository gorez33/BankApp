package com.example.bankapp.controller;

import com.example.bankapp.entity.Client;
import com.example.bankapp.service.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClientController {

    private final Base base;

    @Autowired
    public ClientController (Base base){
        this.base = base;
    }

    @PostMapping("/client")
    public ResponseEntity<?> create(@RequestBody Client client){ // Получаем тело запроса
        base.add(client);  // Добавляем клиента
        return new ResponseEntity<>(HttpStatus.CREATED);// Возвращаем статус
    }
}
