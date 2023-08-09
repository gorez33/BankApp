package com.example.bankapp.dto;

import org.antlr.v4.runtime.misc.NotNull;

public record ClientCreateDTO(
        @NotNull
        String taxCode,
        String firstName,
        String lastName,
        String email,
        String address,
        String phone,
        String managerLastName) {
}
