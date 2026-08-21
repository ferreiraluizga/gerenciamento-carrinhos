package com.ferreiraluizga.exceptions.usuario;

public class UsuarioNaoEncontrado extends RuntimeException {
    public UsuarioNaoEncontrado(String email) {
        super("O usuário com email " + email + " não foi encontrado");
    }
}
