package com.shophub.product.adapters.config;

import com.shophub.product.ProductApplication;
import com.shophub.product.application.core.usecase.ProductUseCase;
import com.shophub.product.application.ports.in.ProductInputPort;
import com.shophub.product.application.ports.out.ProductOutPutPort;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = ProductApplication.class)
public class BeanConfiguration {

    @Bean
    ProductInputPort productUseCase(ProductOutPutPort productOutPutPort) {
        return new ProductUseCase(productOutPutPort);
    }

    @Bean
    public ModelMapper modelMapper() { return new ModelMapper(); }
}
