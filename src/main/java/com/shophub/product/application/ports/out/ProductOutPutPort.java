package com.shophub.product.application.ports.out;

import com.shophub.product.adapters.in.controllers.dto.ProductResponse;
import com.shophub.product.application.core.domain.ProductDomain;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductOutPutPort {
    ProductResponse create(ProductDomain productDomain);

    List<ProductResponse> getAllProducts();

    ProductResponse getProductByName(String name);
}
