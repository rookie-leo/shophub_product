package com.shophub.product.application.ports.in;

import com.shophub.product.adapters.in.controllers.dto.ProductRequest;
import com.shophub.product.adapters.in.controllers.dto.ProductResponse;

public interface ProductInputPort {
    ProductResponse create(ProductRequest product);
}
