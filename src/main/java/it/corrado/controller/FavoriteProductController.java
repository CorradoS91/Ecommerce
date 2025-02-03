package it.corrado.controller;

import it.corrado.dto.FavoriteProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/favproduct")

public interface FavoriteProductController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void addToFavorites(@RequestBody FavoriteProductDto favoriteProductDto);

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void removeFromFavorites(@RequestBody FavoriteProductDto favoriteProductDto);

    @GetMapping("/{userId}/favourites")
    List<FavoriteProductDto> getFavoriteProducts(@PathVariable long userId);
}
