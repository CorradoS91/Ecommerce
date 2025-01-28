package it.corrado.advice;

import it.corrado.error.EcommerceApiError;
import it.corrado.exception.AsinNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.Instant;
@ControllerAdvice
@ResponseBody
public class EcommerceControllerAdvice {
    @ExceptionHandler(AsinNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public EcommerceApiError handleIdNotFoundException(AsinNotFoundException exception, HttpServletRequest request){
        EcommerceApiError error = new EcommerceApiError();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setPath(request.getRequestURL().toString());
        error.setTimestamp(Instant.now());
        error.setMessage(exception.getMessage());
        return error;
    }
}
