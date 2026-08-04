package com.ferreiraluizga.usecases.dispositivo;

import com.ferreiraluizga.entities.Dispositivo;
import com.ferreiraluizga.exceptions.dispositivo.SerialEncontrado;
import com.ferreiraluizga.gateways.DispositivoGateway;

public class SalvarDispositivoUseCaseImpl implements SalvarDispositivoUseCase {

    private final DispositivoGateway dispositivoGateway;

    public SalvarDispositivoUseCaseImpl(DispositivoGateway dispositivoGateway) {
        this.dispositivoGateway = dispositivoGateway;
    }

    @Override
    public Dispositivo execute(Dispositivo dispositivo) {
        dispositivoGateway.buscarDispositivoPorSerial(dispositivo.serial())
                .ifPresent(d -> { throw new SerialEncontrado(dispositivo.serial()); });
        return dispositivoGateway.salvarDispositivo(dispositivo);
    }

}
