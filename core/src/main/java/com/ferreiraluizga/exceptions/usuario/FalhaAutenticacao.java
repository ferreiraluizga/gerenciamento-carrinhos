package com.ferreiraluizga.exceptions.usuario;

public class FalhaAutenticacao extends RuntimeException {
    public FalhaAutenticacao() {
        super("Email e/ou senha inválidos");
    }
}
