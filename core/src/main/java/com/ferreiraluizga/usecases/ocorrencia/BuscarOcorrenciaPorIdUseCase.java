package com.ferreiraluizga.usecases.ocorrencia;

import com.ferreiraluizga.entities.Ocorrencia;

import java.util.Optional;

public interface BuscarOcorrenciaPorIdUseCase {

    Ocorrencia execute(Long id);

}
