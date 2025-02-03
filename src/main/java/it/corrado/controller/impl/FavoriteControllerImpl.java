package it.corrado.controller.impl;

import it.corrado.controller.FavoriteProductController;
import it.corrado.dto.FavoriteProductDto;
import it.corrado.service.FavoriteProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FavoriteControllerImpl implements FavoriteProductController {

    @Autowired
    private final FavoriteProductService favoriteProductService;

    @Override
    public void addToFavorites(FavoriteProductDto favoriteProductDto) {
        favoriteProductService.addToFavorites(favoriteProductDto);
    }

    @Override
    public void removeFromFavorites(FavoriteProductDto favoriteProductDto) {
        favoriteProductService.removeFromFavorites(favoriteProductDto);
    }

    @Override
    public List<FavoriteProductDto> getFavoriteProducts(long userId) {
        return favoriteProductService.getFavoriteProducts(userId);
    }
}
