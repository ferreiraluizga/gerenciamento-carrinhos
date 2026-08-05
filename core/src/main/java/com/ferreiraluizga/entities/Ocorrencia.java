package com.ferreiraluizga.entities;

import com.ferreiraluizga.enums.StatusOcorrencia;

import java.time.LocalDateTime;

public record Ocorrencia(
        Long id,
        Dispositivo dispositivo,
        LocalDateTime data,
        String descricao,
        StatusOcorrencia statusOcorrencia,
        String feedback,
        LocalDateTime dataFeedback
) { }
