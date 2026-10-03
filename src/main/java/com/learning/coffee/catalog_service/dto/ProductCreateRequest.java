package com.learning.coffee.catalog_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreateRequest {

    @NotBlank(message = "Product name is required")
    private String name;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private BigDecimal price;

    @NotNull(message = "Availability is required")
    private Boolean available;

    @NotNull(message = "Amount of calories is required")
    @Positive(message = "Amount of calories must be positive")
    private Integer calories;

    @NotBlank(message = "List of ingredients is required")
    private String ingredients;
}
