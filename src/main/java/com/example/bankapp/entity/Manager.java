package com.example.bankapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Lazy;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "manager")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Manager {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY, orphanRemoval = true, cascade = {MERGE, PERSIST, REFRESH})
    private List<Client> manager;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "manager_product",
            joinColumns = @JoinColumn(name = "manager_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Client> productSet = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return id == manager.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
