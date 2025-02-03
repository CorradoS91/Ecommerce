package it.corrado.dto;

import it.corrado.enums.Role;
import it.corrado.model.Address;
import lombok.*;
import java.util.Set;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {

    private long id;
    private String email;
    private String phone;
    private long balance;
    private Role role;
    private Set<OrderDto> orders;
    private Set<Address> address;

}
