package com.learning.coffee.catalog_service.mapper;

import com.learning.coffee.catalog_service.dto.ProductCreateRequest;
import com.learning.coffee.catalog_service.dto.ProductDto;
import com.learning.coffee.catalog_service.dto.ProductResponse;
import com.learning.coffee.catalog_service.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)

public interface ProductMapper {

    ProductDto toProductDto(Product product);

    List<ProductDto> toProductDtoList(List<Product> products);

    Product toProduct(ProductCreateRequest productCreateRequest);

    ProductResponse toProductResponse(Product product);
}
