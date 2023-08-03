package com.example.bankapp.repository;

import com.example.bankapp.entity.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface AgreementRepository extends JpaRepository<Agreement, UUID> {

    @Query("SELECT a from Agreement a JOIN a.product ag JOIN ag.managerSet ma WHERE ma.id = :managerId AND a.status = :status")
    List<Agreement> findAccountsWhereProductIdIsAndStatusIst (@Param("managerId") int managerId, @Param("status") int status);

    @Query("SELECT a FROM Agreement a " +
            "JOIN a.account acc " +
            "JOIN acc.client c " +
            "WHERE c.id = :clientId")
    List<Agreement> findAgreementsWhereClientIdIs(String clientId);

}
