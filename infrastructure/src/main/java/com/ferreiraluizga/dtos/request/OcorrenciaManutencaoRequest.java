package com.ferreiraluizga.dtos.request;

import jakarta.validation.constraints.NotBlank;

public record OcorrenciaManutencaoRequest(
        @NotBlank String observacao
) { }
