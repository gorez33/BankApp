package com.example.bankapp.controller;

import com.example.bankapp.dto.AccountDTO;
import com.example.bankapp.entity.Account;
import com.example.bankapp.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")

public class AccountController {
    private final AccountService accountService;

    @GetMapping(path = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountDTO> getAllAccounts(){
        return accountService.getAllAccounts();
    }
}
