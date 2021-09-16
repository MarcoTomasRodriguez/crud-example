package com.marcotomasrodriguez.crudexample.repositories;

import com.marcotomasrodriguez.crudexample.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> { }