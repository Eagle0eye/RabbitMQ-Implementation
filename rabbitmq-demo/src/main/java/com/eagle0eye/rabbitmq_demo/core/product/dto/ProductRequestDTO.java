package com.eagle0eye.rabbitmq_demo.core.product.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequestDTO {
    private int id;
    private String name;
    private double price;
}
