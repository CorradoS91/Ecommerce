package it.corrado.service.impl;

import it.corrado.dto.OrderDto;
import it.corrado.dto.UserDto;
import it.corrado.exception.EmailFoundException;
import it.corrado.mapper.OrderMapper;
import it.corrado.mapper.UserMapper;
import it.corrado.model.Order;
import it.corrado.model.User;
import it.corrado.repository.OrderRepository;
import it.corrado.repository.UserRepository;
import it.corrado.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserMapper userMapper;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final OrderMapper orderMapper;
    @Autowired
    private final OrderRepository orderRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userMapper.userDtoToUser(userDto);
        Optional<User> userOpt= userRepository.getUserByEmail(user.getEmail());
        if(userOpt.isPresent()){
            throw new EmailFoundException(user.getEmail(),"This email already exists: "+user.getEmail());
        }else{
            userRepository.save(user);
            return userMapper.userToUserDto(user);
        }

    }

    @Override
    public UserDto updateUser(UserDto userDto, String email) {
        User oldUser=userRepository.getUserByEmail(email).orElseThrow(()->buildEmailFoundException(email));
        userMapper.updateUser(userDto, oldUser);
        userRepository.save(oldUser);
        return userMapper.userToUserDto(oldUser);
    }



    @Override
    public void deleteUser(String email) {
        userRepository.getUserByEmail(email).orElseThrow(()->buildEmailFoundException(email));
        userRepository.deleteUserByEmail(email);
    }
    private RuntimeException buildEmailFoundException(String email) {
        EmailFoundException exception = new EmailFoundException();
        exception.setEmailNotFound(email);
        if (email != null) {
            String ms = "The following Email was not found: %s";
            exception.setMessage(String.format(ms, email));
            return exception;
        }
        return null;
    }
    @Override
    public Set<OrderDto> getUserOrders(String email) {
        User user = userRepository.getUserByEmail(email)
                .orElseThrow(()->buildEmailFoundException(email));
        Set<Order> orders = user.getOrderSet();

        return orders.stream()
                .map(orderMapper::orderToOrderDto)
                .collect(Collectors.toSet());
    }
    @Override
    public OrderDto addOrderToUser(String email, OrderDto orderDto) {
        User user = userRepository.getUserByEmail(email)
                .orElseThrow(()->buildEmailFoundException(email));

        Order order = orderMapper.orderDtoToOrder(orderDto);
        order.setUser(user);
        Order savedOrder = orderRepository.save(order);

        return orderMapper.orderToOrderDto(savedOrder);
    }
}
