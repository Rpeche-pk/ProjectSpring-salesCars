package com.proyect.coches.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ControllersExceptions {

    @ExceptionHandler(EmailValidationException.class)
    public ResponseEntity<ErrorMessage> emailException(Exception ex, HttpServletRequest request){

        int status= HttpStatus.CONFLICT.value();

        ErrorMessage errorMessage=new ErrorMessage(
                ex.getMessage(),
                request.getRequestURI(),
                status,
                LocalDateTime.now());
        return new ResponseEntity<>(errorMessage,HttpStatus.CONFLICT);
    }
}
