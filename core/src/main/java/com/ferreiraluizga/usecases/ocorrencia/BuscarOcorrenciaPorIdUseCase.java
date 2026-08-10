package com.ferreiraluizga.usecases.ocorrencia;

import com.ferreiraluizga.entities.Ocorrencia;

public interface BuscarOcorrenciaPorIdUseCase {

    Ocorrencia execute(Long id);

}
