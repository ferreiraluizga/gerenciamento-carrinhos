package com.ferreiraluizga.entities;

import com.ferreiraluizga.enums.Turno;

public record Turma(
        Long id,
        String nome,
        Turno turno
) { }
