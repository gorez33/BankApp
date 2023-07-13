package com.example.bankapp.repository;

import com.example.bankapp.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository <Client, UUID> {
    @Query ("SELECT a from Client a where a.status = ?1")
    List<Client> getAllClientsWhereStatusIsActive(String status);

    @Query ("SELECT a from Client a where a.balance = ?1")
    List<Client> getAllClientsWhereBalanceMoreThan(BigDecimal balance);
}
