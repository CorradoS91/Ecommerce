package it.corrado.dto;

import it.corrado.model.Address;
import it.corrado.model.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data

public class UserAddressDto {

    private Long userAddressId;
    private User user;
    private Address address;
    private Boolean isPrimary;

}