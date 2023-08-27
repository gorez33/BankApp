package com.example.bankapp.dto;

public record ClientCreateDTO(
        String taxCode,
        String firstName,
        String lastName,
        String email,
        String address,
        String phone,
        String managerLastName,
        String status
) {
    @Override
    public String managerLastName() {
        return managerLastName;
    }

    @Override
    public String status() {
        return status;
    }
}
