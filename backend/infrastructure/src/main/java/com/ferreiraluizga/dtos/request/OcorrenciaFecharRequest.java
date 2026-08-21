package com.ferreiraluizga.dtos.request;

import jakarta.validation.constraints.NotBlank;

public record OcorrenciaFecharRequest(
        @NotBlank String feedback
) { }
