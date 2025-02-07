package it.corrado.controller;

import it.corrado.dto.CartDto;
import it.corrado.dto.OrderDto;
import it.corrado.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cart")

public interface CartController {

    @GetMapping("/{userDto}")
    CartDto getCartByUser(@PathVariable UserDto userDto);

    @PostMapping("/checkout/{userDto}")
    @ResponseStatus(HttpStatus.CREATED)
    OrderDto checkout(@RequestBody UserDto userDto);

}
