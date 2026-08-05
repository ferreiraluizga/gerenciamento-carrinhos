package com.ferreiraluizga.usecases.ocorrencia;

import com.ferreiraluizga.entities.Ocorrencia;
import com.ferreiraluizga.gateways.OcorrenciaGateway;

import java.util.List;

public class ListarOcorrenciasUseCaseImpl implements ListarOcorrenciasUseCase {

    private final OcorrenciaGateway ocorrenciaGateway;

    public ListarOcorrenciasUseCaseImpl(OcorrenciaGateway ocorrenciaGateway) {
        this.ocorrenciaGateway = ocorrenciaGateway;
    }

    @Override
    public List<Ocorrencia> execute() {
        return ocorrenciaGateway.listarOcorrencias();
    }

}
