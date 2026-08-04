package com.ferreiraluizga.exceptions.dispositivo;

public class DispositivoNaoEncontrado extends RuntimeException {
    public DispositivoNaoEncontrado(Long id) {
        super("O dispositivo " + id + " não foi encontrado");
    }
}
