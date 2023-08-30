package com.example.bankapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @Column(name = "currency_code")
    private BigDecimal currencyCode;

    @Column(name = "interest_rate")
    private BigDecimal interestRate;

    @Column(name = "limit")
    private int limit;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "manager_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "manager_id"))
    private Set<Manager> managerSet = new HashSet<>();

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY,
            orphanRemoval = true, cascade = {MERGE, PERSIST, REFRESH})
    private List<Agreement> agreementList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
