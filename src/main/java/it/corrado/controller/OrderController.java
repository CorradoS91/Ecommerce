package it.corrado.controller;

import it.corrado.dto.OrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/order")
public interface OrderController {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    OrderDto createOrder(@RequestBody OrderDto orderDto);
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    OrderDto updateOrder(@PathVariable(name="id") Long id, @RequestBody OrderDto orderDto);
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteOrder(@PathVariable(name="id")Long id);
}
