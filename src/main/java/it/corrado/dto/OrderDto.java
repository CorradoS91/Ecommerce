package it.corrado.dto;
import it.corrado.enums.OrderStatus;
import it.corrado.model.Address;
import it.corrado.model.Product;
import it.corrado.model.User;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data

public class OrderDto {

    private long orderId;
    private BigDecimal orderTotal;
    private OrderStatus orderStatus;
    private String orderPayment;
    private LocalDate doneAt;
    private LocalDate receivedAt;
    private Set<Product> productSet;
    private User user;
    private Address address;

}
