package com.example.bankapp.repository;

import com.example.bankapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
