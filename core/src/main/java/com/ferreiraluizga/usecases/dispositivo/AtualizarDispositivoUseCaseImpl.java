package com.ferreiraluizga.usecases.dispositivo;

import com.ferreiraluizga.entities.Dispositivo;
import com.ferreiraluizga.gateways.DispositivoGateway;

public class AtualizarDispositivoUseCaseImpl implements AtualizarDispositivoUseCase{

    private final DispositivoGateway dispositivoGateway;

    public AtualizarDispositivoUseCaseImpl(DispositivoGateway dispositivoGateway) {
        this.dispositivoGateway = dispositivoGateway;
    }

    @Override
    public Dispositivo execute(Dispositivo dispositivo) {
        return dispositivoGateway.atualizarDispositivo(dispositivo);
    }

}
