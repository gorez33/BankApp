package com.example.bankapp.service;

import com.example.bankapp.dto.AccountCreateDTO;
import com.example.bankapp.dto.AccountDTO;
import java.util.List;

public interface AccountService {
    List<AccountDTO> getAllAccountByStatus (String status);
    List<AccountDTO> getAllAccounts();
    List<AccountDTO> getAccountsWhereProductIdIsAndStatusIs (int productId, String status);

    AccountDTO accountCreateDTO (AccountCreateDTO accountCreateDTO);
}
