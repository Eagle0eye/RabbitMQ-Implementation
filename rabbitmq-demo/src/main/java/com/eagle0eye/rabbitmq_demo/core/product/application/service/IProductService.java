package com.eagle0eye.rabbitmq_demo.core.product.application.service;

import com.eagle0eye.rabbitmq_demo.core.product.domain.Product;
import com.eagle0eye.rabbitmq_demo.core.product.dto.ProductRequestDTO;
import com.eagle0eye.rabbitmq_demo.core.product.dto.ProductResponseDTO;

import java.util.Set;

public interface IProductService {
    Product create(ProductRequestDTO product);
    ProductResponseDTO getProduct(int id);
    Set<ProductResponseDTO> getProducts();
}
