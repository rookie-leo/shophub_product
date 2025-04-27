package com.shophub.product.adapters.in.controllers.dto;

import com.shophub.product.application.core.domain.ProductDomain;
import com.shophub.product.application.core.domain.enums.ProductType;

public record ProductRequest(
        String name,
        Double price,
        String description,
        Integer amount,
        ProductType productType
) {
    public ProductDomain toDomain() {
        return new ProductDomain(name, price, description, amount, productType);
    }
}
