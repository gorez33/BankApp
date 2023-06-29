package com.example.bankapp.entity;

import jakarta.persistence.*;

import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;
import java.util.UUID;

//@Entity
//@Table(name = "account")
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//public class Account {
//    @Id
//    @GeneratedValue(generator = "UUID",strategy = GenerationType.UUID)
//    @Column(name = "id")
//    private UUID id;
//
//    @Column(name = "name")
//    private String name;
//
//    @Column(name = "client_id")
//    private long client_id;
//
//    @Column(name = "type")
//    private int type;
//
//    @Column(name = "status")
//    private String status;
//
//
//
//}
