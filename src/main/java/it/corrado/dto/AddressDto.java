package it.corrado.dto;

import it.corrado.model.Order;
import it.corrado.model.User;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressDto {
    private long addressId;
    private String street;
    private String city;
    private String postalCode;
    private String country;
    private User user;
    private Order order;
}
