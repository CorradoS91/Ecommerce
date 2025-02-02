package it.corrado.dto;
import it.corrado.enums.OrderStatus;
import it.corrado.model.Product;
import lombok.*;

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
}
