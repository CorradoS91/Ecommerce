package it.corrado.error;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class EcommerceApiError {
    private Instant timestamp;
    private int status;
    private String message;
    private String path;
}
