package com.shophub.product.adapters.in.controllers;

import com.shophub.product.adapters.in.controllers.dto.ProductRequest;
import com.shophub.product.adapters.in.controllers.dto.ProductResponse;
import com.shophub.product.application.ports.in.ProductInputPort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    final ProductInputPort productUseCase;

    public ProductController(ProductInputPort productServicePort) {
        this.productUseCase = productServicePort;
    }

    @GetMapping()
    public String test() {
        return "Hello world!";
    }

    @PostMapping()
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest product) {
        return ResponseEntity.status(201).body(productUseCase.create(product));
    }

}
