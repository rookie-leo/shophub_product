package com.shophub.product.application.ports.in;

import com.shophub.product.adapters.in.controllers.dto.ProductRequest;
import com.shophub.product.adapters.in.controllers.dto.ProductResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductInputPort {
    ProductResponse create(ProductRequest product);

    List<ProductResponse> getAllProducts();

    ProductResponse getByName(String name);
}
