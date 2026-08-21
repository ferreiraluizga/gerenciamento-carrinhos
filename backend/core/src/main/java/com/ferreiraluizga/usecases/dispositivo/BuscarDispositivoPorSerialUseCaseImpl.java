package com.ferreiraluizga.usecases.dispositivo;

import com.ferreiraluizga.entities.Dispositivo;
import com.ferreiraluizga.exceptions.dispositivo.SerialEncontrado;
import com.ferreiraluizga.gateways.DispositivoGateway;

import java.util.Optional;

public class BuscarDispositivoPorSerialUseCaseImpl implements BuscarDispositivoPorSerialUseCase {

    private final DispositivoGateway dispositivoGateway;

    public BuscarDispositivoPorSerialUseCaseImpl(DispositivoGateway dispositivoGateway) {
        this.dispositivoGateway = dispositivoGateway;
    }

    @Override
    public Dispositivo execute(String serial) {
        return dispositivoGateway.buscarDispositivoPorSerial(serial)
                .orElseThrow(() -> new SerialEncontrado(serial));
    }

}
