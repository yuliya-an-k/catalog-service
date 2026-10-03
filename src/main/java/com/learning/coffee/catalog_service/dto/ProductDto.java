package com.learning.coffee.catalog_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private String name;

    private BigDecimal price;

    private Boolean available;

    private Instant createdAt;

    private Instant updatedAt;

    private Integer calories;

    private String ingredients;
}
