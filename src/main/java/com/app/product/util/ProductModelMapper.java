package com.app.product.util;

import com.app.product.model.api.Product;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between Product entities and Product DTOs using MapStruct.
 */
@Mapper(componentModel = "spring")
public interface ProductModelMapper {

    /**
     * Convert a Product entity to a Product DTO.
     *
     * @param product The Product entity to be converted.
     * @return The corresponding Product DTO.
     */
    Product productEntityToDto(com.app.product.model.data.Product product);

    /**
     * Convert a Product DTO to a Product entity.
     *
     * @param product The Product DTO to be converted.
     * @return The corresponding Product entity.
     */
    com.app.product.model.data.Product productDtoToEntity(Product product);
}