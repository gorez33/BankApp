package com.example.bankapp.dto;



public record ClientDTO(
        String id,
        String status,
        String taxCode,
        String firstName,
        String lastName,
        String email,
        String address,
        String phone,
        String managerLastName
        ) {
}
