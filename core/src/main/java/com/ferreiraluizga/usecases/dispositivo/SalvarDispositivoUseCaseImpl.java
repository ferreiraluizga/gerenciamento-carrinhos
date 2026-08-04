package com.ferreiraluizga.usecases.dispositivo;

import com.ferreiraluizga.entities.Dispositivo;
import com.ferreiraluizga.gateways.DispositivoGateway;

public class SalvarDispositivoUseCaseImpl implements SalvarDispositivoUseCase {

    private final DispositivoGateway dispositivoGateway;

    public SalvarDispositivoUseCaseImpl(DispositivoGateway dispositivoGateway) {
        this.dispositivoGateway = dispositivoGateway;
    }

    @Override
    public Dispositivo execute(Dispositivo dispositivo) {
        return dispositivoGateway.salvarDispositivo(dispositivo);
    }

}
