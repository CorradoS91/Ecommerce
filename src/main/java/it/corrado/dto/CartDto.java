package it.corrado.dto;

import it.corrado.model.Address;
import it.corrado.model.Product;
import it.corrado.model.User;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data

public class CartDto {

    private long cartId;

    private BigDecimal cartTotal;

    private User user;

    private Set<Product> productSet;

    private Address address;
}
