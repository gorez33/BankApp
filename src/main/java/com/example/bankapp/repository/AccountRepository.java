package com.example.bankapp.repository;

import com.example.bankapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
    @Query("SELECT a from Account a where a.status = ?1")
    List<Account> getAllAccountsWhereStatusIs (String status);

    @Query("SELECT a FROM Account a JOIN a.agreement ag JOIN ag.product p WHERE p.id = :productId AND a.status = :status")
    List<Account> findAccountsWhereProductIdIsAndStatusIs(@Param("productId") int productId, @Param("status") int status);


}
