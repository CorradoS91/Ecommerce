package it.corrado.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FavoriteProductNotFound extends RuntimeException {
    private Long FavoriteProductIdNotFound;
    private String message;
}
