package com.ferreiraluizga.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OcorrenciaRequest(
        @NotNull Long dispositivoId,
        @NotBlank String descricao
) { }
