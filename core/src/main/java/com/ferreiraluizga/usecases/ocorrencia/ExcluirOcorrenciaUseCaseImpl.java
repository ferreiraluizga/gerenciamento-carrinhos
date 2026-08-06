package com.ferreiraluizga.usecases.ocorrencia;

import com.ferreiraluizga.gateways.OcorrenciaGateway;

public class ExcluirOcorrenciaUseCaseImpl implements ExcluirOcorrenciaUseCase{

    private final OcorrenciaGateway ocorrenciaGateway;

    public ExcluirOcorrenciaUseCaseImpl(OcorrenciaGateway ocorrenciaGateway) {
        this.ocorrenciaGateway = ocorrenciaGateway;
    }

    @Override
    public void execute(Long id) {
        ocorrenciaGateway.excluirOcorrencia(id);
    }
}
