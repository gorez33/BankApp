package com.example.bankapp.controller;

import com.example.bankapp.dto.AccountDTO;
import com.example.bankapp.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.Matchers.hasSize;

import static org.hamcrest.core.Is.is;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    AccountService accountService;

    @Test
    void getAllAccounts() throws Exception {
        List<AccountDTO> mockAccounts = new ArrayList<>();
        AccountDTO accountDTO = new AccountDTO("223e4499-e89b-12d3-a456-426655442222", "PDD", "deposit",
                "active", "USD", "223e4999-e89b-12d3-a456-426655445555", "2",
                "active", "2020-06-05", "2020-11-17");

        mockAccounts.add(accountDTO);

        when(accountService.getAllAccounts()).thenReturn(mockAccounts);
        mockMvc.perform(get("/account/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(mockAccounts.size())))
                .andExpect(jsonPath("$[0].id", is("223e4499-e89b-12d3-a456-426655442222")))
                .andExpect(jsonPath("$[0].name", is("PDD")))
                .andExpect(jsonPath("$[0].type", is("deposit")))
                .andExpect(jsonPath("$[0].status", is("active")))
                .andExpect(jsonPath("$[0].currencyCode", is("USD")))
                .andExpect(jsonPath("$[0].client_id", is("223e4999-e89b-12d3-a456-426655445555")))
                .andExpect(jsonPath("$[0].manager_id", is("2")))
                .andExpect(jsonPath("$[0].agreement_status", is("active")))
                .andExpect(jsonPath("$[0].created_at", is("2020-06-05")))
                .andExpect(jsonPath("$[0].updated_at", is("2020-11-17")));
        verify(accountService, times(1)).getAllAccounts();
    }


    @Test
    void getAllAccountByStatus() {
    }

    @Test
    void getAccountsWhereProductIdIsAndStatusIs() {
    }
}