package com.learning.coffee.catalog_service.mapper;

import com.learning.coffee.catalog_service.dto.ProductCreateRequest;
import com.learning.coffee.catalog_service.dto.ProductDto;
import com.learning.coffee.catalog_service.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto toProductDto(Product product);

    List<ProductDto> toProductDtoList(List<Product> products);

    Product toProduct(ProductCreateRequest productCreateRequest);
}
