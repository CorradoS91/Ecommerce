package it.corrado.dto;


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

}
