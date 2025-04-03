package com.eagle0eye.rabbitmq_demo.core.product.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product  implements Serializable {
    private int id;
    private String name;
    private double price;
}
