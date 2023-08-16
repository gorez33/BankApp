package com.example.bankapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "agreement")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Agreement {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "interest_rate")
    private BigDecimal interestRate;

    @Column(name = "status")
    private String status;

    @Column(name = "sum")
    private BigDecimal sum;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @ManyToOne(cascade = {MERGE, PERSIST, REFRESH},fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @OneToOne()
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agreement agreement = (Agreement) o;
        return Objects.equals(id, agreement.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
