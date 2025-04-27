package com.shophub.product.adapters.out;

import com.shophub.product.adapters.in.controllers.dto.ProductResponse;
import com.shophub.product.adapters.out.repositories.ProductEntity;
import com.shophub.product.adapters.out.repositories.ProductRepository;
import com.shophub.product.application.core.domain.ProductDomain;
import com.shophub.product.application.ports.out.ProductOutPutPort;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductAdapter implements ProductOutPutPort {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductAdapter(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductResponse create(ProductDomain productDomain) {
        var productEntity = productRepository.save(modelMapper.map(productDomain, ProductEntity.class));
        return modelMapper.map(productEntity, ProductResponse.class);
    }
}
