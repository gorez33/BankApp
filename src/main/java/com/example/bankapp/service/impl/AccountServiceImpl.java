package com.example.bankapp.service.impl;

import com.example.bankapp.dto.AccountDTO;
import com.example.bankapp.entity.Account;
import com.example.bankapp.mapper.AccountMapper;
import com.example.bankapp.repository.AccountRepository;
import com.example.bankapp.service.AccountService;
import com.example.bankapp.service.exception.AccountNotFoundException;
import com.example.bankapp.service.exception.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;

    /**
     * Retrieves a list of account DTOs based on the specified account status.
     *
     * @param status The status of accounts to retrieve.
     * @return A list of {@link AccountDTO} objects corresponding to the given status.
     * @throws AccountNotFoundException if no accounts with the specified status are found.
     */

    @Override
    public List<AccountDTO> getAllAccountByStatus(String status) {
        List<Account> accountStatus = accountRepository.getAllAccountsWhereStatusIs(status);
        if (accountStatus == null || accountStatus.isEmpty()){
            throw new AccountNotFoundException(ErrorMessage.ACCOUNT_NOT_FOUND_BY_STATUS);
        }else {
            return accountMapper.toDTOList(accountStatus);
        }
    }

    /**
     * Retrieves a list of all account DTOs.
     *
     * @return A list of all {@link AccountDTO} objects.
     * @throws AccountNotFoundException if no accounts are found.
     */

    @Override
    public List<AccountDTO> getAllAccounts() {
        List<Account> accountList = accountRepository.findAllAccount();
        if (accountList == null || accountList.isEmpty()) {
            throw new AccountNotFoundException(ErrorMessage.ACCOUNTS_NOT_FOUND);
        } else {
            return accountMapper.toDTOList(accountList);
        }
    }

    /**
     * Retrieves a list of account DTOs based on the specified product ID and account status.
     *
     * @param productId The ID of the product associated with the accounts.
     * @param status The status of accounts to retrieve.
     * @return A list of {@link AccountDTO} objects corresponding to the given product ID and status.
     * @throws AccountNotFoundException if no accounts with the specified product ID and status are found.
     */

    @Override
    public List<AccountDTO> getAccountsWhereProductIdIsAndStatusIs(int productId, String status) {
        List<Account> accounts = accountRepository.findAccountsWhereProductIdIsAndStatusIs(productId, status);
        if (accounts.isEmpty()) {
            throw new AccountNotFoundException(ErrorMessage.ACCOUNT_NOT_FOUND_BY_ID_AND_STATUS);
        }
        return accountMapper.toDTOList(accounts);
    }

}
