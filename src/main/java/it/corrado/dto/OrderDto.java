package it.corrado.dto;
import it.corrado.enums.OrderStatus;
import it.corrado.model.Address;
import it.corrado.model.Product;
import it.corrado.model.User;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {
    private long orderId;
    private String orderTotal;
    private OrderStatus orderStatus;
    private String orderPayment;
    private LocalDate doneAt;
    private LocalDate receivedAt;
    private Set<Product> productSet;
    private User user;
    private Address address;

    public OrderDto(BigDecimal bigDecimal, OrderStatus orderStatus, String creditCard, UserDto u1, AddressDto a1DTO, Set<ProductDto> ps1) {
    }
}
