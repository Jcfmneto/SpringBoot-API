package com.streaming.project.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CredenciaisInvalidas.class)
    public ResponseEntity<?> handleCredenciaisInvalidas(CredenciaisInvalidas ex){
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(ex.getMessage());
    }
    @ExceptionHandler(UsuarioCadastrado.class)
    public ResponseEntity<?> handleUsuarioCadastrado(UsuarioCadastrado ex){
        return  ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(ex.getMessage());
    }
}
