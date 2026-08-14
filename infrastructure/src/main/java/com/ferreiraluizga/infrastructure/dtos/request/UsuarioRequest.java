package com.ferreiraluizga.infrastructure.dtos.request;

public record UsuarioRequest(
        String nome,
        String email,
        String senha
) { }
