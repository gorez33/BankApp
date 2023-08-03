package com.example.bankapp.repository;

import com.example.bankapp.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

}
