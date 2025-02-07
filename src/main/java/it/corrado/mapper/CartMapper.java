package it.corrado.mapper;

import it.corrado.dto.CartDto;
import it.corrado.model.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

public interface CartMapper {

    CartDto cartToCartDto(Cart cart);

    Cart cartDtoToCart(CartDto cartDto);

}
