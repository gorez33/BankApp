package com.example.bankapp.controller;

import com.example.bankapp.dto.ClientDTO;
import com.example.bankapp.entity.Client;
import com.example.bankapp.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    @GetMapping(path = "/active")
    public List<ClientDTO> getAllClientsByStatusIsActive(){
        return clientService.getAllClientsByStatusIsActive();
    }
    @GetMapping(path = "/balance/{balance}")
    public List <ClientDTO> getAllClientsWhereBalanceMoreThan(@PathVariable("balance")BigDecimal balance){
        return clientService.getAllClientsByBalanceMoreThan(balance);
    }
    @GetMapping(path = "/transaction{transaction}")
    public List<ClientDTO> getAllClientsByTransactionMoreThan(@PathVariable("transaction")int transactionCount){
        return clientService.getAllClientsByTransactionMoreThan(transactionCount);
    }

}
