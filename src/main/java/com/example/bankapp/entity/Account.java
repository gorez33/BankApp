package com.example.bankapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "status")
    private String status;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @ManyToOne(cascade = {MERGE, PERSIST, REFRESH})
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @OneToMany(mappedBy = "debitAccount")
    private List<Transaction> transactionDebit; //

    @OneToMany(mappedBy = "creditAccount")
    private List<Transaction> transactionCredit;

    @OneToOne(mappedBy = "account", cascade = ALL)
    @JoinColumn (name = "agreement_id", referencedColumnName = "id")
    private Agreement agreement;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(name, account.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

