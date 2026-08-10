package com.ferreiraluizga.infrastructure.dtos.response;

import com.ferreiraluizga.enums.Turno;

public record TurmaResponse(
        Long id,
        String nome,
        Turno turno
) { }
