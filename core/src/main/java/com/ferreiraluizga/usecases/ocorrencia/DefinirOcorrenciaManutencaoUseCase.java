package com.ferreiraluizga.usecases.ocorrencia;

import com.ferreiraluizga.entities.Ocorrencia;

public interface DefinirOcorrenciaManutencaoUseCase {

    Ocorrencia execute(Long id, String observacao);

}
