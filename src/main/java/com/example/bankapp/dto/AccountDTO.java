package com.example.bankapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.UuidGenerator;

public record AccountDTO(
        String id,
        String name,
        String type,
        String status,
        String currencyCode,
        String client_id,
        String manager_id,
        String agreement_status,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        String created_at,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        String updated_at) {
}
