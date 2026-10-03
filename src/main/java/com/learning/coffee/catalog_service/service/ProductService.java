package com.learning.coffee.catalog_service.service;

import com.learning.coffee.catalog_service.dto.ProductCreateRequest;
import com.learning.coffee.catalog_service.dto.ProductDto;
import com.learning.coffee.catalog_service.dto.ProductUpdateRequest;
import com.learning.coffee.catalog_service.entity.Product;
import com.learning.coffee.catalog_service.mapper.ProductMapper;
import com.learning.coffee.catalog_service.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductDto> getProducts() {
        List<Product> products = productRepository.findAll();
        return productMapper.toProductDtoList(products);
    }

    @Transactional
    public ProductDto saveProduct(ProductCreateRequest productCreateRequest) {
        Product product = productMapper.toProduct(productCreateRequest);
        productRepository.save(product);
        return productMapper.toProductDto(product);

    }

    @Transactional(readOnly = true)
    public ProductDto getProduct(UUID id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Product with ID {} not found", id);
                    return new EntityNotFoundException("Product not found");
                });
        return productMapper.toProductDto(product);
    }

    @Transactional
    public ProductDto updateProduct(UUID id, ProductUpdateRequest productUpdateRequest) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Product with ID {} not found", id);
                    return new EntityNotFoundException("Product not found");
                });
        if (productUpdateRequest.getPrice() != null) {
            product.setPrice(productUpdateRequest.getPrice());
        }
        if (productUpdateRequest.getAvailable() != null) {
            product.setAvailable(productUpdateRequest.getAvailable());
        }
        if (productUpdateRequest.getCalories() != null) {
            product.setCalories(productUpdateRequest.getCalories());
        }
        if (productUpdateRequest.getIngredients() != null) {
            product.setIngredients(productUpdateRequest.getIngredients());
        }
        return productMapper.toProductDto(product);
    }
}
