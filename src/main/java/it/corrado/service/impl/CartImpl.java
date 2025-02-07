package it.corrado.service.impl;

import it.corrado.dto.CartDto;
import it.corrado.dto.OrderDto;
import it.corrado.dto.UserDto;
import it.corrado.enums.OrderStatus;
import it.corrado.mapper.CartMapper;
import it.corrado.mapper.OrderMapper;
import it.corrado.mapper.UserMapper;
import it.corrado.model.Cart;
import it.corrado.model.Order;
import it.corrado.model.User;
import it.corrado.repository.CartRepository;
import it.corrado.repository.OrderRepository;
import it.corrado.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor

public class CartImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public CartDto getCartByUser(UserDto userDto) {
        Cart cart= cartRepository.findByUser(userMapper.userDtoToUser(userDto)).orElseThrow(()->new RuntimeException(("User Not Found")));
        return cartMapper.cartToCartDto(cart);
    }

    @Override
    public OrderDto checkoutOrder(UserDto userDto) {
        CartDto cartDto = getCartByUser(userDto);
        Cart cart = cartMapper.cartDtoToCart(cartDto);
        OrderDto orderDto=convertToOrder(cartDto);
        cartRepository.delete(cartMapper.cartDtoToCart(cartDto));
        Order order = orderRepository.save(orderMapper.orderDtoToOrder(orderDto));
        return orderMapper.orderToOrderDto(order);
    }
    @Override
    public OrderDto convertToOrder(CartDto cartDto) {
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderTotal(cartDto.getCartTotal());
        orderDto.setOrderStatus(OrderStatus.AUTHORIZED);
        orderDto.setOrderPayment("Balance");
        orderDto.setUser(cartDto.getUser());
        orderDto.setProductSet(cartDto.getProductSet());
        orderDto.setAddress(cartDto.getAddress());
        orderDto.setDoneAt(LocalDate.now());
        return orderDto;
    }
}
