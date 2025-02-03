package it.corrado.controller.impl;

import it.corrado.controller.OrderController;
import it.corrado.dto.OrderDto;
import it.corrado.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class OrderControllerImpl implements OrderController {

    @Autowired
    private final OrderService orderService;

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        return orderService.createOrder(orderDto);
    }

    @Override
    public OrderDto updateOrder(Long id, OrderDto orderDto) {
        return orderService.updateOrder(orderDto,id);
    }

    @Override
    public void deleteOrder(Long id) {
        orderService.deleteOrder(id);
    }
}
