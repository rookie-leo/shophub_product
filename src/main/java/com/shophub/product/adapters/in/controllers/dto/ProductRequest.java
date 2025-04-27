package com.shophub.product.adapters.in.controllers.dto;

import com.shophub.product.application.core.domain.ProductDomain;

public record ProductRequest(
        String name,
        Double price,
        String description,
        Integer amount
) {
    public ProductDomain toDomain() {
        return new ProductDomain(name, price, description, amount);
    }
}
