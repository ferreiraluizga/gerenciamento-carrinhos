package com.ferreiraluizga.dtos.request;

import com.ferreiraluizga.enums.Turno;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TurmaRequest(
        @NotBlank String nome,
        @NotNull Turno turno
) { }
