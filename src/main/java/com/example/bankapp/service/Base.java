package com.example.bankapp.service;

import com.example.bankapp.entity.Client;

import java.util.UUID;

public interface Base {
    void add (Client client);

    void delete (UUID id);

}

