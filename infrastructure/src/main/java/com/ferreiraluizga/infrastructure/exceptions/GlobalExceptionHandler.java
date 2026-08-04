package com.ferreiraluizga.infrastructure.exceptions;

import com.ferreiraluizga.exceptions.CarrinhoNaoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CarrinhoNaoEncontrado.class)
    public ProblemDetail handleException(CarrinhoNaoEncontrado e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setTitle("Recurso Não Encontrado");
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }
}
