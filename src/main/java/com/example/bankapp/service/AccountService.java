package com.example.bankapp.service;

import com.example.bankapp.dto.AccountDTO;
import com.example.bankapp.entity.Account;

import java.util.List;

public interface AccountService {
    AccountDTO getAccountByName (String name);
    List<AccountDTO> getAllAccounts();
    AccountDTO getAccountById(String id);
}
