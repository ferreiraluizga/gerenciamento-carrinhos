package com.ferreiraluizga.usecases.ocorrencia;

import com.ferreiraluizga.entities.Dispositivo;
import com.ferreiraluizga.entities.Ocorrencia;
import com.ferreiraluizga.enums.StatusOcorrencia;
import com.ferreiraluizga.exceptions.dispositivo.DispositivoNaoEncontrado;
import com.ferreiraluizga.gateways.DispositivoGateway;
import com.ferreiraluizga.gateways.OcorrenciaGateway;

import java.time.LocalDateTime;

public class SalvarOcorrenciaUseCaseImpl implements SalvarOcorrenciaUseCase{

    private final OcorrenciaGateway ocorrenciaGateway;
    private final DispositivoGateway dispositivoGateway;

    public SalvarOcorrenciaUseCaseImpl(OcorrenciaGateway ocorrenciaGateway, DispositivoGateway dispositivoGateway) {
        this.ocorrenciaGateway = ocorrenciaGateway;
        this.dispositivoGateway = dispositivoGateway;
    }

    @Override
    public Ocorrencia execute(Ocorrencia ocorrencia) {
        Dispositivo dispositivo = dispositivoGateway.buscarDispositivoPorId(ocorrencia.dispositivo().id())
                .orElseThrow(() -> new DispositivoNaoEncontrado(ocorrencia.dispositivo().id()));

        return ocorrenciaGateway.salvarOcorrencia(new Ocorrencia(
                null,
                dispositivo,
                LocalDateTime.now(),
                ocorrencia.descricao(),
                StatusOcorrencia.ABERTA,
                null,
                null
        ));
    }

}
