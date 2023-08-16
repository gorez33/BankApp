package com.example.bankapp.service;

import com.example.bankapp.dto.ClientDTO;

import java.math.BigDecimal;
import java.util.List;

public interface ClientService {
    List<ClientDTO> getAllClientsByStatusIsActive (String status);
    List<ClientDTO> getAllClientsByBalanceMoreThan (BigDecimal balance);
    List<ClientDTO> getAllClientsByTransactionMoreThan (int transactionCount);
}
