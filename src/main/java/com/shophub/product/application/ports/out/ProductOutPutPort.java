package com.shophub.product.application.ports.out;

import com.shophub.product.adapters.in.controllers.dto.ProductResponse;
import com.shophub.product.application.core.domain.ProductDomain;

public interface ProductOutPutPort {
    ProductResponse create(ProductDomain productDomain);
}
