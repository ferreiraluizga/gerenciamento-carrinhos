package com.ferreiraluizga.usecases.ocorrencia;

import com.ferreiraluizga.entities.Dispositivo;
import com.ferreiraluizga.entities.Ocorrencia;
import com.ferreiraluizga.exceptions.ocorrencia.OcorrenciaNaoEncontrada;
import com.ferreiraluizga.gateways.DispositivoGateway;
import com.ferreiraluizga.gateways.OcorrenciaGateway;

public class DefinirOcorrenciaManutencaoUseCaseImpl implements DefinirOcorrenciaManutencaoUseCase {

    private final OcorrenciaGateway ocorrenciaGateway;
    private final DispositivoGateway dispositivoGateway;

    public DefinirOcorrenciaManutencaoUseCaseImpl(OcorrenciaGateway ocorrenciaGateway, DispositivoGateway dispositivoGateway) {
        this.ocorrenciaGateway = ocorrenciaGateway;
        this.dispositivoGateway = dispositivoGateway;
    }

    @Override
    public Ocorrencia execute(Long id, String observacao) {
        Ocorrencia ocorrencia = ocorrenciaGateway.buscarOcorrenciaPorId(id)
                .orElseThrow(() -> new OcorrenciaNaoEncontrada(id));

        Dispositivo dispositivo = dispositivoGateway.buscarDispositivoPorId(ocorrencia.dispositivo().id())
                .orElseThrow(() -> new OcorrenciaNaoEncontrada(ocorrencia.dispositivo().id()));

        dispositivoGateway.atualizarDispositivo(new Dispositivo(
                dispositivo.id(),
                dispositivo.serial(),
                dispositivo.numDispositivo(),
                dispositivo.modeloDispositivo(),
                dispositivo.sistemaOperacional(),
                dispositivo.ativo(),
                observacao,
                true,
                dispositivo.carrinho()
        ));

        return ocorrenciaGateway.definirOcorrenciaManutencao(id, observacao);
    }

}
