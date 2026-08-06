package com.ferreiraluizga.infrastructure.dtos.request;

public record OcorrenciaRequest(
        Long dispositivoId,
        String descricao
) { }
