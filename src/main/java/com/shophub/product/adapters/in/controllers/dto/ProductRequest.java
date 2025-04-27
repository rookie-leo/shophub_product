package com.shophub.product.adapters.in.controllers.dto;

import com.shophub.product.application.core.domain.ProductDomain;
import com.shophub.product.application.core.domain.enums.ProductType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRequest(
        @NotBlank(message = "Name is mandatory.")
        String name,

        @NotNull(message = "Minimum value of price is 0.01.")
        Double price,

        String description,

        @NotNull(message = "Minimum amount is 0.")
        Integer amount,

        @NotNull(message = "Product type is mandatory.")
        ProductType productType
) {
    public ProductDomain toDomain() {
        return new ProductDomain(name, price, description, amount, productType);
    }
}
