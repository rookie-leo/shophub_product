package com.shophub.product.application.ports.out;

import com.shophub.product.adapters.in.controllers.dto.ProductResponse;
import com.shophub.product.application.core.domain.ProductDomain;

import java.util.List;
import java.util.UUID;

public interface ProductOutPutPort {
    ProductResponse create(ProductDomain productDomain);

    List<ProductResponse> getAllProducts();

    ProductResponse getProductByName(String name);

    ProductResponse updateProduct(UUID productId, ProductDomain domain);

    void deleteProduct(UUID productId);
}
