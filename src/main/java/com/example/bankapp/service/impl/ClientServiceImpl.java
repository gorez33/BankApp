package com.example.bankapp.service.impl;

import com.example.bankapp.dto.ClientCreateDTO;
import com.example.bankapp.dto.ClientDTO;
import com.example.bankapp.entity.Client;
import com.example.bankapp.entity.Manager;
import com.example.bankapp.mapper.ClientMapper;
import com.example.bankapp.repository.ClientRepository;
import com.example.bankapp.repository.ManagerRepository;
import com.example.bankapp.service.ClientService;
import com.example.bankapp.service.exception.ClientNotFoundException;
import com.example.bankapp.service.exception.ErrorMessage;
import com.example.bankapp.service.exception.ManagerNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;
    private final ManagerRepository managerRepository;



    @Override
    public List<ClientDTO> getAllClientsByStatusIsActive() {
        List<Client> clientStatus = clientRepository.getAllClientsWhereStatusIsActive();
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

    @Override
    @Transactional
    public ClientDTO createClient(ClientCreateDTO clientCreateDTO) {
        Client client = clientMapper.dtoToEntity(clientCreateDTO);
        Optional<Manager> optionalManager = managerRepository.findManagerByName(clientCreateDTO.managerLastName());

        // найден ли менеджер
        if (optionalManager.isPresent()) {
            Manager manager = optionalManager.get();
            // Установите полученного менеджера
            client.setManager(manager);
        } else {
            throw new ManagerNotFoundException(ErrorMessage.MANAGER_NOT_FOUNDED);
            // Обработка ситуации, когда менеджер не найден
        }
        client.setStatus(clientCreateDTO.status());
        client.setCreatedAt(LocalDateTime.now());
        client.setUpdatedAt(LocalDateTime.now());

        return clientMapper.entityToDto(clientRepository.save(client));
    }
}



