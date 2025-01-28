package it.corrado.mapper;

import it.corrado.dto.ProductDto;
import it.corrado.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {
    ProductDto productToProductDto(Product product);
    Product productToProductDto(ProductDto productDto);
}
