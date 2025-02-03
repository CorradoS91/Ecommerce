package it.corrado.service.impl;

import it.corrado.dto.OrderDto;
import it.corrado.exception.IdNotFoundException;
import it.corrado.mapper.OrderMapper;
import it.corrado.model.Order;
import it.corrado.repository.OrderRepository;
import it.corrado.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class OrderServiceImpl implements OrderService {

    @Autowired
    private final OrderMapper orderMapper;

    @Autowired
    private final OrderRepository orderRepository;

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order=orderMapper.orderDtoToOrder(orderDto);
        orderRepository.save(order);
        return orderMapper.orderToOrderDto(order);
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto, Long id) {
        Order oldOrder= orderRepository.findById(id).orElseThrow(()->buildIdNotFoundException(id));
        orderMapper.updateOrder(orderDto,oldOrder);
        orderRepository.save(oldOrder);
        return orderMapper.orderToOrderDto(oldOrder);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.findById(id).orElseThrow(()->buildIdNotFoundException(id));
        orderRepository.deleteById(id);
    }

    private RuntimeException buildIdNotFoundException(Long id) {
        IdNotFoundException exception = new IdNotFoundException();
        exception.setIdNotFound(id);
        if (id != null) {
            String ms = "The following Id was not found: %d";
            exception.setMessage(String.format(ms, id));
            return exception;
        }
        return null;
    }
}
