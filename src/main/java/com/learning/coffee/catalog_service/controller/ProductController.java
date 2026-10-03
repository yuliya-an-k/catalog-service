package com.learning.coffee.catalog_service.controller;

import com.learning.coffee.catalog_service.dto.ProductCreateRequest;
import com.learning.coffee.catalog_service.dto.ProductDto;
import com.learning.coffee.catalog_service.dto.ProductUpdateRequest;
import com.learning.coffee.catalog_service.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable UUID id) {
        return productService.getProduct(id);
    }

    @PostMapping
    public ProductDto saveProduct(@Valid @RequestBody ProductCreateRequest productCreateRequest) {
        return productService.saveProduct(productCreateRequest);
    }

    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable UUID id,
                                    @Valid @RequestBody ProductUpdateRequest productUpdateRequest) {
        return productService.updateProduct(id, productUpdateRequest);
    }
}
