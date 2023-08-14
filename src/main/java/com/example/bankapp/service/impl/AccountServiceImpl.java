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
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;


    @Override
    public List<AccountDTO> getAllAccountByStatus(String status) {
        List<Account> accountStatus = accountRepository.getAllAccountsWhereStatusIs(status);
        if (accountStatus == null || accountStatus.isEmpty()){
            throw new AccountNotFoundException(ErrorMessage.ACCOUNT_NOT_FOUND_BY_STATUS);
        }else {
            return accountMapper.toDTOList(accountStatus);
        }
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        List<Account> accountList = accountRepository.findAllAccount();
        if (accountList == null || accountList.isEmpty()) {
            throw new AccountNotFoundException(ErrorMessage.ACCOUNTS_NOT_FOUND);
        } else {
            return accountMapper.toDTOList(accountList);
        }
    }

    @Override
    public List<AccountDTO> getAccountsWhereProductIdIsAndStatusIs(UUID productId, String status) {
        List<Account> accounts = accountRepository.findAccountsWhereProductIdIsAndStatusIs(productId, status);
        if (accounts.isEmpty()) {
            throw new AccountNotFoundException(ErrorMessage.ACCOUNT_NOT_FOUND_BY_ID_AND_STATUS);
        }
        return accountMapper.toDTOList(accounts);
    }

}
