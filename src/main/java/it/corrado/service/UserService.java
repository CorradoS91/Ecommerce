package it.corrado.service;

import it.corrado.dto.OrderDto;
import it.corrado.dto.UserDto;
import java.util.Set;


public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto updateUser(UserDto userDto, String email);

    void deleteUser(String email);

    Set<OrderDto> getUserOrders(String email);

    OrderDto addOrderToUser(String email, OrderDto orderDto);

}
