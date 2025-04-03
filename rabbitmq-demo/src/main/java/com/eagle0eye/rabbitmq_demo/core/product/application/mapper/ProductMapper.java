package com.eagle0eye.rabbitmq_demo.core.product.application.mapper;

import com.eagle0eye.rabbitmq_demo.core.product.domain.Product;
import com.eagle0eye.rabbitmq_demo.core.product.dto.ProductRequestDTO;
import com.eagle0eye.rabbitmq_demo.core.product.dto.ProductResponseDTO;

public class ProductMapper {
    public static ProductResponseDTO toDTO(Product product) {
        return ProductResponseDTO.builder()
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }
    public static Product toModel(ProductRequestDTO dto) {
        return Product.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .build();
    }
}
