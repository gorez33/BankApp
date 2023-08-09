package com.example.bankapp.service.impl;

import com.example.bankapp.dto.AccountDTO;
import com.example.bankapp.entity.Account;
import com.example.bankapp.repository.AccountRepository;
import com.example.bankapp.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public AccountDTO getAccountByName(String name) {
        return null;
    }



    @Override
    public List<AccountDTO> getAllAccounts() {
        List<Account> accountList = accountRepository.findAllAccount();

        return null;
    }

    @Override
    public AccountDTO getAccountById(String id) {
        return null;
    }
}
