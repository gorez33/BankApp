package com.example.bankapp.repository;

import com.example.bankapp.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository <Client, UUID> {
    @Query ("SELECT a FROM Client a WHERE a.status = 'active'")
    List<Client> getAllClientsWhereStatusIsActive();

    @Query("SELECT c FROM Client c JOIN c.accountList a WHERE a.balance > :balance")
    List<Client> getAllClientsWhereBalanceMoreThan(@Param("balance") BigDecimal balance);

    @Query("SELECT c FROM Client c " +
            "JOIN c.accountList a " +
            "JOIN a.transactionDebit tDebit " +
            "JOIN a.transactionCredit tCredit " +
            "WHERE (SIZE(tDebit) + SIZE(tCredit)) > ?1")
    List<Client> getAllClientsWhereTransactionMoreThan(int transactionCount);


}
