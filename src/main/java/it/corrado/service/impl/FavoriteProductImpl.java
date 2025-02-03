package it.corrado.service.impl;

import it.corrado.dto.FavoriteProductDto;
import it.corrado.exception.AsinNotFoundException;
import it.corrado.exception.IdNotFoundException;
import it.corrado.mapper.FavoriteProductMapper;
import it.corrado.model.Product;
import it.corrado.model.User;
import it.corrado.repository.FavoriteProductRepository;
import it.corrado.repository.ProductRepository;
import it.corrado.repository.UserRepository;
import it.corrado.service.FavoriteProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class FavoriteProductImpl implements FavoriteProductService {
    @Autowired
    private FavoriteProductRepository favoriteProductRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FavoriteProductMapper favoriteProductMapper;

    @Override
    public void addToFavorites(FavoriteProductDto favoriteProductDto) {
            User user =userRepository.findById(favoriteProductDto.getUser().getId()).orElseThrow(()->buildIdNotFoundException(favoriteProductDto.getUser().getId()));
            Product product = productRepository.findById(favoriteProductDto.getProduct().getAsin()).orElseThrow(()->buildAsinNotFoundException(favoriteProductDto.getProduct().getAsin()));
            if(!favoriteProductRepository.existsByUserAndProduct(user,product)){
                favoriteProductRepository.save(favoriteProductMapper.favoriteProductDtoToFavoriteProduct(favoriteProductDto));
            }
    }

    @Override
    public void removeFromFavorites(FavoriteProductDto favoriteProductDto) {
        User user = userRepository.getUserById(favoriteProductDto.getUser().getId())
                .orElseThrow(()->buildIdNotFoundException(favoriteProductDto.getUser().getId()));
        Product product = productRepository.findById(favoriteProductDto.getProduct().getAsin())
                .orElseThrow(()->buildAsinNotFoundException(favoriteProductDto.getProduct().getAsin()));
        favoriteProductRepository.findByUserAndProduct(user, product)
                .orElseThrow(()->buildFavoriteProductNotFoundException(favoriteProductDto.getProduct().getAsin()));
        favoriteProductRepository.delete(favoriteProductMapper.favoriteProductDtoToFavoriteProduct(favoriteProductDto));
    }

    @Override
    public List<FavoriteProductDto> getFavoriteProducts(long userId) {
        return List.of();
    }


    private RuntimeException buildIdNotFoundException(Long userId) {
        IdNotFoundException exception = new IdNotFoundException();
        exception.setIdNotFound(userId);
        if (userId != null) {
            String ms = "The following Id was not found: %d";
            exception.setMessage(String.format(ms, userId));
            return exception;
        }
        return null;
    }
    private RuntimeException buildAsinNotFoundException(Long asin) {
        AsinNotFoundException exception = new AsinNotFoundException();
        exception.setAsinNotFound(asin);
        if (asin != null) {
            String ms = "The following Asin was not found: %d";
            exception.setMessage(String.format(ms, asin));
            return exception;
        }
        return null;
    }
    private RuntimeException buildFavoriteProductNotFoundException(Long favoriteProductId) {
        AsinNotFoundException exception = new AsinNotFoundException();
        exception.setAsinNotFound(favoriteProductId);
        if (favoriteProductId != null) {
            String ms = "ID Favorite Product was not found: %d";
            exception.setMessage(String.format(ms, favoriteProductId));
            return exception;
        }
        return null;
    }
}
