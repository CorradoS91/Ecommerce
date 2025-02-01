package it.corrado.dto;

import it.corrado.enums.Role;
import lombok.*;
import java.util.List;

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
    private List<OrderDto> orders;

}
