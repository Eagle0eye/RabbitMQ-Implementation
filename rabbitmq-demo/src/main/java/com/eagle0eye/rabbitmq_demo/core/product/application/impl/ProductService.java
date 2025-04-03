package com.eagle0eye.rabbitmq_demo.core.product.application.impl;

import com.eagle0eye.rabbitmq_demo.core.product.application.mapper.ProductMapper;
import com.eagle0eye.rabbitmq_demo.core.product.application.service.IProductService;
import com.eagle0eye.rabbitmq_demo.core.product.domain.Product;
import com.eagle0eye.rabbitmq_demo.core.product.dto.ProductRequestDTO;
import com.eagle0eye.rabbitmq_demo.core.product.dto.ProductResponseDTO;
import com.eagle0eye.rabbitmq_demo.infrastructure.rabbitmq.producer.JsonMessageProducer;
import com.eagle0eye.rabbitmq_demo.infrastructure.rabbitmq.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProductService implements IProductService {

    private Set<Product> products ;

    ProductService() {
        products = new HashSet<>();
        products.add(new Product(1,"Book",12.22));
        products.add(new Product(2,"Note Book",2.22));
        products.add(new Product(3,"Pen",5.22));
    }

    @Autowired
    private MessageProducer producer ;
    @Autowired
    private JsonMessageProducer jsonMessageProducer;


    @Override
    public Product create(ProductRequestDTO product) {
        Product getProduct = ProductMapper.toModel(product);
        products.add(getProduct);
        jsonMessageProducer.process(getProduct);
        producer.send(product.toString());
        return getProduct;
    }

    @Override
    public ProductResponseDTO getProduct(int id) {
        return ProductMapper.toDTO(products.stream().filter(product -> product.getId() == id).findFirst().get());
    }

    @Override
    public Set<ProductResponseDTO> getProducts() {
        Set<ProductResponseDTO> ResultProducts = new HashSet<>();
        products.forEach(product -> {
            ResultProducts.add(ProductMapper.toDTO(product));
        });
        return ResultProducts;
    }
}
