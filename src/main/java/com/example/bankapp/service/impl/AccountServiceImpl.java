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


    @Override
    public List<AccountDTO> getAllAccountByStatus(String name) {

        return null;
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        List<Account> accountList = accountRepository.findAllAccount();
        if (accountList == null) {
            throw new AccountNotFoundException(ErrorMessage.ACCOUNTS_NOT_FOUND);
        } else {
            return accountMapper.toDTOList(accountList);
        }
    }

    @Override
    public List<Account> getAccountsWhereProductIdIsAndStatusIs(int productId, String status) {
        return null;
    }

}
