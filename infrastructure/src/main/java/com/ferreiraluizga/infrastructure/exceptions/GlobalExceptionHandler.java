package com.ferreiraluizga.infrastructure.exceptions;

import com.ferreiraluizga.exceptions.carrinho.CarrinhoNaoEncontrado;
import com.ferreiraluizga.exceptions.dispositivo.DispositivoNaoEncontrado;
import com.ferreiraluizga.exceptions.dispositivo.SerialEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CarrinhoNaoEncontrado.class)
    public ProblemDetail handleCarrinhoException(CarrinhoNaoEncontrado e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setTitle("Carrinho Não Encontrado");
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }

    @ExceptionHandler(DispositivoNaoEncontrado.class)
    public ProblemDetail handleDispositivoException(DispositivoNaoEncontrado e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setTitle("Dispositivo Não Encontrado");
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }

    @ExceptionHandler(SerialEncontrado.class)
    public ProblemDetail handleSerialException(SerialEncontrado e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, e.getMessage());
        problemDetail.setTitle("Conflito de Dados");
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }
}
