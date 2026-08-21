package com.ferreiraluizga.usecases.ocorrencia;

import com.ferreiraluizga.entities.Ocorrencia;

public interface FecharOcorrenciaUseCase {

    Ocorrencia execute(Long id, String feedback);

}
