package com.ferreiraluizga.exceptions.usuario;

public class EmailExistente extends RuntimeException {
    public EmailExistente(String email) {
        super("O email " + email + " já foi cadastrado no sistema");
    }
}
