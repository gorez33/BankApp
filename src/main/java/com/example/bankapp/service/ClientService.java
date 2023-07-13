package com.example.bankapp.service;

import com.example.bankapp.entity.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ClientService implements Base {

    private List<Client> arrayList = new ArrayList<>();

    @Override
    public void add(Client client) {
        arrayList.add(client);
    }

    @Override
    public void delete(UUID id) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getId()== id){
                arrayList.remove(i);
            }
        }
    }
}
