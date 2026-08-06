package com.ferreiraluizga.usecases.ocorrencia;

import com.ferreiraluizga.entities.Ocorrencia;

import java.time.LocalDateTime;

public interface FecharOcorrenciaUseCase {

    Ocorrencia execute(Long id, String feedback, LocalDateTime dataFeedback);

}
