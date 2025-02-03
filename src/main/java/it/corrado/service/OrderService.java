package it.corrado.service;

import it.corrado.dto.OrderDto;

public interface OrderService {

    OrderDto createOrder(OrderDto orderDto);

    OrderDto updateOrder(OrderDto orderDto, Long id);

    void deleteOrder(Long id);

}
