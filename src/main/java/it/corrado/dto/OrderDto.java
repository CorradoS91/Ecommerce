package it.corrado.dto;
import it.corrado.model.OrderStatus;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

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
    private List<ProductDto> products;
}
