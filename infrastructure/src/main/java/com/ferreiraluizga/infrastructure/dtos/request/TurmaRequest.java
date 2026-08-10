package com.ferreiraluizga.infrastructure.dtos.request;

import com.ferreiraluizga.enums.Turno;

public record TurmaRequest(
        String nome,
        Turno turno
) { }
