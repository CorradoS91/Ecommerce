package it.corrado.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmailNotFoundException extends RuntimeException {
  private String emailNotFound;
  private String message;
}
