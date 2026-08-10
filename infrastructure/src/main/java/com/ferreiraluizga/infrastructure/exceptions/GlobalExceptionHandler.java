package com.ferreiraluizga.infrastructure.exceptions;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.ferreiraluizga.exceptions.carrinho.CarrinhoNaoEncontrado;
import com.ferreiraluizga.exceptions.dispositivo.DispositivoNaoEncontrado;
import com.ferreiraluizga.exceptions.dispositivo.SerialEncontrado;
import com.ferreiraluizga.exceptions.ocorrencia.OcorrenciaNaoEncontrada;
import com.ferreiraluizga.exceptions.turma.TurmaNaoEncontrada;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ProblemDetail handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        String detailMessage = "O corpo da requisição contém um formato JSON inválido.";

        Throwable rootCause = ex.getMostSpecificCause();

        if (rootCause instanceof InvalidFormatException formatException) {
            if (formatException.getTargetType() != null && formatException.getTargetType().isEnum()) {
                String campo = formatException.getPath().isEmpty()
                        ? "desconhecido"
                        : formatException.getPath().get(formatException.getPath().size() - 1).getFieldName();

                Object valorInvalido = formatException.getValue();
                Object[] valoresAceitos = formatException.getTargetType().getEnumConstants();

                detailMessage = String.format(
                        "O valor '%s' é inválido para o campo '%s'. Valores aceitos: %s",
                        valorInvalido, campo, Arrays.toString(valoresAceitos)
                );
            }
        }

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, detailMessage);
        problemDetail.setTitle("Requisição Inválida");
        problemDetail.setProperty("timestamp", Instant.now());

        return problemDetail;
    }

    @ExceptionHandler(OcorrenciaNaoEncontrada.class)
    public ProblemDetail handleDispositivoException(OcorrenciaNaoEncontrada e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setTitle("Ocorrência Não Encontrada");
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }

    @ExceptionHandler(TurmaNaoEncontrada.class)
    public ProblemDetail handleDispositivoException(TurmaNaoEncontrada e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setTitle("Turma Não Encontrada");
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }
}
