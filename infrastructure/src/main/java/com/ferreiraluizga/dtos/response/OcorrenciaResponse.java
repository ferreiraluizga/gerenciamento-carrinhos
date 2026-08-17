package com.ferreiraluizga.dtos.response;

import com.ferreiraluizga.enums.StatusOcorrencia;

import java.time.LocalDateTime;

public record OcorrenciaResponse(
        Long id,
        DispositivoResponse dispositivo,
        LocalDateTime data,
        String descricao,
        StatusOcorrencia statusOcorrencia,
        String feedback,
        LocalDateTime dataFeedback
) { }
