package it.corrado.controller;

import it.corrado.dto.OrderDto;
import it.corrado.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
public interface UserController {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    UserDto createUser(@RequestBody UserDto userDto);
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    UserDto updateUser(@PathVariable(name="email") String email,@RequestBody UserDto userDto);
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteUser(@PathVariable(name="email")String email);
    @GetMapping("/{email}/orders")
    List<OrderDto> getUserOrders(@PathVariable String email);
    @PostMapping("/{email}/orders")
    OrderDto addOrderToUser(@PathVariable String email, @RequestBody OrderDto orderDto);
}
