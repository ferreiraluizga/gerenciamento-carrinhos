package com.ferreiraluizga.usecases.ocorrencia;

import com.ferreiraluizga.entities.Dispositivo;
import com.ferreiraluizga.entities.Ocorrencia;
import com.ferreiraluizga.exceptions.dispositivo.DispositivoNaoEncontrado;
import com.ferreiraluizga.exceptions.ocorrencia.OcorrenciaNaoEncontrada;
import com.ferreiraluizga.gateways.DispositivoGateway;
import com.ferreiraluizga.gateways.OcorrenciaGateway;

public class FecharOcorrenciaUseCaseImpl implements FecharOcorrenciaUseCase{

    private final OcorrenciaGateway ocorrenciaGateway;
    private final DispositivoGateway dispositivoGateway;

    public FecharOcorrenciaUseCaseImpl(OcorrenciaGateway ocorrenciaGateway, DispositivoGateway dispositivoGateway) {
        this.ocorrenciaGateway = ocorrenciaGateway;
        this.dispositivoGateway = dispositivoGateway;
    }

    @Override
    public Ocorrencia execute(Long id) {
        Ocorrencia ocorrencia = ocorrenciaGateway.buscarOcorrenciaPorId(id)
                .orElseThrow(() -> new OcorrenciaNaoEncontrada(id));
        Dispositivo dispositivo = dispositivoGateway.buscarDispositivoPorId(ocorrencia.dispositivo().id())
                .orElseThrow(() -> new DispositivoNaoEncontrado(ocorrencia.dispositivo().id()));
        dispositivoGateway.atualizarDispositivo(new Dispositivo(
                dispositivo.id(),
                dispositivo.serial(),
                dispositivo.numDispositivo(),
                dispositivo.modeloDispositivo(),
                dispositivo.sistemaOperacional(),
                dispositivo.ativo(),
                dispositivo.observacao(),
                false,
                dispositivo.carrinho()
        ));
        return ocorrenciaGateway.fecharOcorrencia(id);
    }
}
