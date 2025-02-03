package it.corrado.dto;

import it.corrado.model.Product;
import it.corrado.model.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FavoriteProductDto {

    private Long favouriteProductId;
    private User user;
    private Product product;

}
