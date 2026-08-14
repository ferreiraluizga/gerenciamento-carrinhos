package com.ferreiraluizga.infrastructure.dtos.response;

import com.ferreiraluizga.enums.UsuarioRole;

public record UsuarioResponse(
        Long id,
        String nome,
        String email,
        String senha,
        UsuarioRole role
) { }
