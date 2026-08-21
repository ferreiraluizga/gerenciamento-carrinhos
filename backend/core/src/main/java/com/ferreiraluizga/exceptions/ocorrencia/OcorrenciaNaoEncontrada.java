package com.ferreiraluizga.exceptions.ocorrencia;

public class OcorrenciaNaoEncontrada extends RuntimeException {
    public OcorrenciaNaoEncontrada(Long id) {
        super("A ocorrência " + id + " não foi encontrada");
    }
}
