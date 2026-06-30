package com.spring.userdept.controller;

import java.time.Instant;

import com.spring.userdept.exceptions.StandardError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.spring.userdept.service.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
@RestControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Recurso não encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND; // Código HTTP 404

        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError(error);
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    // Captura erros de digitação de ENUM e JSON malformado
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<StandardError> badRequestEnum(HttpMessageNotReadableException e, HttpServletRequest request){
        String error = "Dados da requisição inválidos.";
        HttpStatus status = HttpStatus.BAD_REQUEST;

        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError(error);

        // Mensagem simplificada para o usuário humano entender
        err.setMessage("O departamento informado é inválido ou o corpo do JSON está mal formatado.");
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }
}
