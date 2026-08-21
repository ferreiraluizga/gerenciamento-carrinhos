package com.ferreiraluizga.exceptions.dispositivo;

public class SerialEncontrado extends RuntimeException {
    public SerialEncontrado(String serial) {
        super("O serial " + serial + " já está cadastrado no sistema");
    }
}
