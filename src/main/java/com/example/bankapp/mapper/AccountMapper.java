package com.example.bankapp.mapper;

import com.example.bankapp.dto.AccountDTO;
import com.example.bankapp.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(source = "account.agreement.status", target = "agreement_status")
    @Mapping(source = "account.client.id", target = "client_id")
    @Mapping(source = "account.client.manager.id", target = "manager_id")
    AccountDTO toDTO(Account account);

    List<AccountDTO> toDTOList(List<Account> accountList);
}
