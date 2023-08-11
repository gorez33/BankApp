package com.example.bankapp.service;

import com.example.bankapp.dto.AccountDTO;
import com.example.bankapp.entity.Account;

import java.util.List;

public interface AccountService {
    List<AccountDTO> getAllAccountByStatus (String name);
    List<AccountDTO> getAllAccounts();
    List<Account> getAccountsWhereProductIdIsAndStatusIs (int productId, String status);
}
