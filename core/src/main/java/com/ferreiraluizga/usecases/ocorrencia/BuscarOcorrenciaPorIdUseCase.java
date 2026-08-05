package com.ferreiraluizga.usecases.ocorrencia;

import com.ferreiraluizga.entities.Ocorrencia;

import java.util.Optional;

public interface BuscarOcorrenciaPorIdUseCase {

    Optional<Ocorrencia> execute(Long id);

}
