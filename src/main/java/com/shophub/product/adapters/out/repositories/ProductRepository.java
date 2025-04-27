package com.shophub.product.adapters.out.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
    ProductEntity findByName(String name);
}
