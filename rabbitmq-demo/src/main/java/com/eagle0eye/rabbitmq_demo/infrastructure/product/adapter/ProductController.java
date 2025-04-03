package com.eagle0eye.rabbitmq_demo.infrastructure.product.adapter;

import com.eagle0eye.rabbitmq_demo.core.product.application.impl.ProductService;
import com.eagle0eye.rabbitmq_demo.core.product.domain.Product;
import com.eagle0eye.rabbitmq_demo.core.product.dto.ProductRequestDTO;
import com.eagle0eye.rabbitmq_demo.core.product.dto.ProductResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService mProductService;

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequestDTO product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mProductService.create(product));
    }

    @GetMapping
    public ResponseEntity<Set<ProductResponseDTO>> products() {
        return ResponseEntity.ok(mProductService.getProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable int id) {
        return ResponseEntity.ok(mProductService.getProduct(id));
    }


}
