package com.shophub.product.application.ports.in;

import com.shophub.product.adapters.in.controllers.dto.ProductRequest;
import com.shophub.product.adapters.in.controllers.dto.ProductResponse;

import java.util.List;
import java.util.UUID;

public interface ProductInputPort {
    ProductResponse create(ProductRequest product);

    List<ProductResponse> getAllProducts();

    ProductResponse getByName(String name);

    ProductResponse updateProduct(UUID productId, ProductRequest productRequest);

    void deleteProduct(UUID productId);
}
