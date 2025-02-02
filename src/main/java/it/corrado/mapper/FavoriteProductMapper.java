package it.corrado.mapper;

import it.corrado.dto.FavoriteProductDto;
import it.corrado.model.FavoriteProduct;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FavoriteProductMapper {
    FavoriteProductDto favoriteProductToFavoriteProductDto(FavoriteProduct favoriteProduct);
    FavoriteProduct favoriteProductDtoToFavoriteProduct(FavoriteProductDto favoriteProductDto);
    void updateFavoriteProduct(FavoriteProductDto favoriteProductDto, @MappingTarget FavoriteProduct favoriteProduct);
}
