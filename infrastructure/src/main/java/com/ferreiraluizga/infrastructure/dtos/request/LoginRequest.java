package com.ferreiraluizga.infrastructure.dtos.request;

public record LoginRequest(
        String email,
        String senha
) { }
