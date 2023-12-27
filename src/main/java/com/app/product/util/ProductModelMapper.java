package com.app.product.util;

import com.app.product.model.api.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductModelMapper {

    Product productEntityToDto(com.app.product.model.data.Product product);
    com.app.product.model.data.Product productDtoToEntity(Product product);
}
