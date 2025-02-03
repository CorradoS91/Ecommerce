package it.corrado.mapper;

import it.corrado.dto.OrderDto;
import it.corrado.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

public interface OrderMapper {

    OrderDto orderToOrderDto(Order order);

    Order orderDtoToOrder(OrderDto orderDto);

    void updateOrder(OrderDto orderDto, @MappingTarget Order order);

}
