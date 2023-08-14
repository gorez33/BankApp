package com.example.bankapp.controller;

import com.example.bankapp.dto.AccountDTO;
import com.example.bankapp.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

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
    @GetMapping(path = "/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountDTO> getAllAccountByStatus (@PathVariable("status")String status){
        return accountService.getAllAccountByStatus(status);
    }
    @GetMapping(path = "/status/{status}/id{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountDTO> getAccountsWhereProductIdIsAndStatusIs (@PathVariable UUID id, @PathVariable String status){
        return accountService.getAccountsWhereProductIdIsAndStatusIs(id,status);
    }
}
