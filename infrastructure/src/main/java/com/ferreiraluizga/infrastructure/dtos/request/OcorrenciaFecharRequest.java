package com.ferreiraluizga.infrastructure.dtos.request;

import jakarta.validation.constraints.NotBlank;

public record OcorrenciaFecharRequest(
        @NotBlank String feedback
) { }
