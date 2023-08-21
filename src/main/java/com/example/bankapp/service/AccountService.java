package com.example.bankapp.service;

import com.example.bankapp.dto.AccountDTO;

import java.util.List;
import java.util.UUID;

public interface AccountService {
    List<AccountDTO> getAllAccountByStatus (String status);
    List<AccountDTO> getAllAccounts();
    List<AccountDTO> getAccountsWhereProductIdIsAndStatusIs (int productId, String status);

}
