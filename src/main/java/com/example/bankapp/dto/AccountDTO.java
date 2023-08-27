package com.example.bankapp.dto;


public record AccountDTO(
        String id,
        String name,
        String type,
        String status,
        String currencyCode,
        String client_id,
        String manager_id,
        String agreement_status
        ) {
}
