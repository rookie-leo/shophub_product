package com.shophub.product.application.core.usecase;

import com.shophub.product.adapters.in.controllers.dto.ProductRequest;
import com.shophub.product.adapters.in.controllers.dto.ProductResponse;
import com.shophub.product.application.core.domain.ProductDomain;
import com.shophub.product.application.ports.in.ProductInputPort;
import com.shophub.product.application.ports.out.ProductOutPutPort;

public class ProductUseCase implements ProductInputPort {

    private final ProductOutPutPort productAdapter;

    public ProductUseCase(ProductOutPutPort productOutPutPort) {
        productAdapter = productOutPutPort;
    }

    @Override
    public ProductResponse create(ProductRequest productRequest) {
        ProductDomain productDomain = productRequest.toDomain();
        return productAdapter.create(productDomain);
    }
}
