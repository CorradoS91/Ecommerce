package it.corrado.controller.impl;

import it.corrado.controller.UserController;
import it.corrado.dto.OrderDto;
import it.corrado.dto.UserDto;
import it.corrado.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {
    @Autowired
    private final UserService userService;
    @Override
    public UserDto createUser(UserDto userDto) {
        return userService.createUser(userDto);
    }

    @Override
    public UserDto updateUser(String email, UserDto userDto) {
        return userService.updateUser(userDto,email);
    }

    @Override
    public void deleteUser(Long id) {
    }
    @Override
    public List<OrderDto> getUserOrders(String email) {
        return userService.getUserOrders(email);
    }
    @Override
    public OrderDto addOrderToUser(String email,OrderDto orderDto) {
        return userService.addOrderToUser(email, orderDto);
    }
}
