package com.example.bankapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record ClientAfterDTO(
        String id,
        String taxCode,
        String firstName,
        String lastName,
        String email,
        String address,
        String phone,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime dataClientCreated,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime dataClientUpdated

        ) {
}
