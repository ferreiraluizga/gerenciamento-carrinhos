package com.ferreiraluizga.entities;

import com.ferreiraluizga.enums.UsuarioRole;

public record Usuario(
        Long id,
        String nome,
        String email,
        String senha,
        UsuarioRole role
) { }