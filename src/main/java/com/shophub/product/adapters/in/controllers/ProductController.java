package com.shophub.product.adapters.in.controllers;

import com.shophub.product.adapters.in.controllers.dto.ProductRequest;
import com.shophub.product.adapters.in.controllers.dto.ProductResponse;
import com.shophub.product.application.ports.in.ProductInputPort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    final ProductInputPort productUseCase;

    public ProductController(ProductInputPort productServicePort) {
        this.productUseCase = productServicePort;
    }

    @PostMapping()
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest product) {
        return ResponseEntity.status(201).body(productUseCase.create(product));
    }

    @GetMapping()
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productUseCase.getAllProducts());
    }

    @GetMapping("/{name}")
    public ResponseEntity<ProductResponse> getByName(@PathVariable String name) {
        return ResponseEntity.ok(productUseCase.getByName(name));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable UUID productId,
            @Valid @RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(productUseCase.updateProduct(productId, productRequest));
    }
}
