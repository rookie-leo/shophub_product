package com.shophub.product.adapters.out;

import com.shophub.product.adapters.in.controllers.dto.ProductResponse;
import com.shophub.product.adapters.out.repositories.ProductEntity;
import com.shophub.product.adapters.out.repositories.ProductRepository;
import com.shophub.product.application.core.domain.ProductDomain;
import com.shophub.product.application.ports.out.ProductOutPutPort;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Component
public class ProductAdapter implements ProductOutPutPort {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductAdapter(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public ProductResponse create(ProductDomain productDomain) {
        var productEntity = productRepository.save(modelMapper.map(productDomain, ProductEntity.class));
        return modelMapper.map(productEntity, ProductResponse.class);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(p -> modelMapper.map(p, ProductResponse.class))
                .toList();
    }

    @Override
    public ProductResponse getProductByName(String name) {
        return modelMapper.map(productRepository.findByName(name), ProductResponse.class);
    }

    @Override
    public ProductResponse updateProduct(UUID productId, ProductDomain productDomain) {
        var oldProduct = productRepository.findById(productId);

        if (oldProduct.isEmpty()) throw new RuntimeException("Product not found!");// TODO - personalisar exception para ProductNotFoundException

        var product = oldProduct.get();
        product.setName(productDomain.getName());
        product.setPrice(productDomain.getPrice());
        product.setDescription(productDomain.getDescription());
        product.setAmount(productDomain.getAmount());
        product.setProductType(productDomain.getProductType());

        return modelMapper.map(productRepository.save(product), ProductResponse.class);
    }

    @Override
    public void deleteProduct(UUID productId) {
        try {
            productRepository.delete(productRepository.findById(productId).get());
        } catch (NoSuchElementException ex) {
            throw new RuntimeException("Product not found.");// TODO - personalisar exception para ProductNotFoundException
        }
    }
}
