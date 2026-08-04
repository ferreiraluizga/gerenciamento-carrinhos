package com.ferreiraluizga.usecases.dispositivo;

import com.ferreiraluizga.entities.Dispositivo;
import com.ferreiraluizga.exceptions.dispositivo.DispositivoNaoEncontrado;
import com.ferreiraluizga.exceptions.dispositivo.SerialEncontrado;
import com.ferreiraluizga.gateways.DispositivoGateway;

public class AtualizarDispositivoUseCaseImpl implements AtualizarDispositivoUseCase{

    private final DispositivoGateway dispositivoGateway;

    public AtualizarDispositivoUseCaseImpl(DispositivoGateway dispositivoGateway) {
        this.dispositivoGateway = dispositivoGateway;
    }

    @Override
    public Dispositivo execute(Dispositivo dispositivo) {
        dispositivoGateway.buscarDispositivoPorId(dispositivo.id())
                .orElseThrow(() -> new DispositivoNaoEncontrado(dispositivo.id()));
        dispositivoGateway.buscarDispositivoPorSerial(dispositivo.serial())
                .ifPresent(d -> {
                    throw new SerialEncontrado(dispositivo.serial());
                });
        return dispositivoGateway.atualizarDispositivo(dispositivo);
    }

}
