package it.corrado.dto;


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
    private int quantity;
    private String imageUrl;

}

