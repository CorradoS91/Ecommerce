package it.corrado.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
    private long Asin;
    private String name;
    private double price;
    private String quantity;
}
