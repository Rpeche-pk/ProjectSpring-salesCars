package com.proyect.coches.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorMessage {

    private final String message;
    private final String path;
    private final int status;
    private final LocalDateTime fecha;

    public ErrorMessage( String message, String path, int status, LocalDateTime fecha) {

        this.message = message;
        this.path = path;
        this.status = status;
        this.fecha = fecha;
    }
}
