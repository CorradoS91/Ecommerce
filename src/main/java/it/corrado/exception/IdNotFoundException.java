package it.corrado.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IdNotFoundException extends RuntimeException {
    private Long idNotFound;
    private String message;
}