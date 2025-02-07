package it.corrado.controller.impl;

import it.corrado.controller.CartController;
import it.corrado.dto.CartDto;
import it.corrado.dto.OrderDto;
import it.corrado.dto.UserDto;
import it.corrado.model.User;
import it.corrado.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class CartControllerImpl implements CartController {

    @Autowired
    private final CartService cartService;

    @Override
    public CartDto getCartByUser(UserDto userDto) {
        return cartService.getCartByUser(userDto);
    }

    @Override
    public OrderDto checkout(UserDto userDto) {
        return cartService.checkoutOrder(userDto);
    }

}
