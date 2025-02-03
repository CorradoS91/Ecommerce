package it.corrado.service;

import it.corrado.dto.FavoriteProductDto;
import java.util.List;

public interface FavoriteProductService {

    void addToFavorites(FavoriteProductDto favoriteProductDto);

    void removeFromFavorites(FavoriteProductDto favoriteProductDto);

    List<FavoriteProductDto> getFavoriteProducts(long userId);

}
