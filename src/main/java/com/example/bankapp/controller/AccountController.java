package com.example.bankapp.controller;

import com.example.bankapp.dto.AccountCreateDTO;
import com.example.bankapp.dto.AccountDTO;
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
    public List<AccountDTO> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @GetMapping(path = "/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountDTO> getAllAccountByStatus(@PathVariable("status")String status) {
        return accountService.getAllAccountByStatus(status);
    }

    @GetMapping(path = "/productId/{id}/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountDTO> getAccountsWhereProductIdIsAndStatusIs(@PathVariable int id, @PathVariable("status") String status) {
        return accountService.getAccountsWhereProductIdIsAndStatusIs(id,status);
    }

    @PostMapping(path = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountDTO createAccount(@RequestBody AccountCreateDTO accountCreateDTO) {
        return accountService.accountCreateDTO(accountCreateDTO);
    }
}
