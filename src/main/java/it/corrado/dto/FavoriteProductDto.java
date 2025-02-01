package it.corrado.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FavoriteProductDto {
    private long userId;
    private long productId;
}
