package com.ferreiraluizga.usecases.ocorrencia;

import com.ferreiraluizga.entities.Ocorrencia;
import com.ferreiraluizga.exceptions.ocorrencia.OcorrenciaNaoEncontrada;
import com.ferreiraluizga.gateways.OcorrenciaGateway;

import java.util.Optional;

public class BuscarOcorrenciaPorIdUseCaseImpl implements BuscarOcorrenciaPorIdUseCase {

    private final OcorrenciaGateway ocorrenciaGateway;

    public BuscarOcorrenciaPorIdUseCaseImpl(OcorrenciaGateway ocorrenciaGateway) {
        this.ocorrenciaGateway = ocorrenciaGateway;
    }

    @Override
    public Ocorrencia execute(Long id) {
        return ocorrenciaGateway.buscarOcorrenciaPorId(id)
                .orElseThrow(() -> new OcorrenciaNaoEncontrada(id));
    }

}
