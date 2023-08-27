package com.example.bankapp.repository;

import com.example.bankapp.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
    @Query("SELECT m FROM Manager m WHERE m.id = :id")
    Optional<Manager> findById (@Param("id")Long id);

    @Query("SELECT a FROM Manager a WHERE a.lastName=?1")
    Optional<Manager> findManagerByName(String lastName);
}
