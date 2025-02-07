package it.corrado.service;

import it.corrado.dto.CartDto;
import it.corrado.dto.OrderDto;
import it.corrado.dto.UserDto;
import it.corrado.model.Cart;

import java.util.Optional;

public interface CartService {

    CartDto getCartByUser(UserDto userDto);

    OrderDto checkoutOrder(UserDto userDto);

    OrderDto convertToOrder(CartDto cartDto);
}
