package com.example.bankapp.service.impl;

import com.example.bankapp.dto.ClientDTO;
import com.example.bankapp.entity.Client;
import com.example.bankapp.mapper.ClientMapper;
import com.example.bankapp.repository.ClientRepository;
import com.example.bankapp.service.ClientService;
import com.example.bankapp.service.exception.ClientNotFoundException;
import com.example.bankapp.service.exception.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;



    @Override
    public List<ClientDTO> getAllClientsByStatusIsActive(String status) {
        List<Client> clientStatus = clientRepository.getAllClientsWhereStatusIsActive("active");
        if (clientStatus == null || clientStatus.isEmpty()){
            throw new ClientNotFoundException(ErrorMessage.CLIENT_NOT_FOUND_BY_STATUS_ACTIVE);
        }else {
            return clientMapper.toDTOList(clientStatus);
        }
    }

    @Override
    public List<ClientDTO> getAllClientsByBalanceMoreThan(BigDecimal balance) {
        List<Client> clientBalance = clientRepository.getAllClientsWhereBalanceMoreThan(balance);
        if (clientBalance.isEmpty()){
            throw new ClientNotFoundException(ErrorMessage.CLIENT_NOT_FOUND_BY_BALANCE_MORE_THAN);
        }else{
            return clientMapper.toDTOList(clientBalance);
        }

    }

    @Override
    public List<ClientDTO> getAllClientsByTransactionMoreThan(int transactionCount) {
        List<Client> clientsTransaction = clientRepository.getAllClientsWhereTransactionMoreThan(transactionCount);
        if (clientsTransaction == null || clientsTransaction.isEmpty()){
            throw new ClientNotFoundException(ErrorMessage.CLIENT_NOT_FOUND_BY_TRANSACTION_MORE_THAN);
        }
        return clientMapper.toDTOList(clientsTransaction);
    }
}
