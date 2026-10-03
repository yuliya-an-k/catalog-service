package com.learning.coffee.catalog_service.dto;

import jakarta.validation.constraints.Pattern;
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
public class ProductUpdateRequest {

    @Positive(message = "Price must be positive")
    private BigDecimal price;

    private Boolean available;

    @Positive(message = "Amount of calories must be positive")
    private Integer calories;

    @Pattern(regexp = "^(?!\\s+$).+",
            message = "List of ingredients must not be empty")
    private String ingredients;
}
