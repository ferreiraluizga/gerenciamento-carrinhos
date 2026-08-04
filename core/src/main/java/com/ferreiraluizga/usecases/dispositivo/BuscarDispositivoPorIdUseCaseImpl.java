package com.ferreiraluizga.usecases.dispositivo;

import com.ferreiraluizga.entities.Dispositivo;
import com.ferreiraluizga.gateways.DispositivoGateway;

import java.util.Optional;

public class BuscarDispositivoPorIdUseCaseImpl implements BuscarDispositivoPorIdUseCase{

    private final DispositivoGateway dispositivoGateway;

    public BuscarDispositivoPorIdUseCaseImpl(DispositivoGateway dispositivoGateway) {
        this.dispositivoGateway = dispositivoGateway;
    }

    @Override
    public Optional<Dispositivo> execute(Long id) {
        return dispositivoGateway.buscarDispositivoPorId(id);
    }

}
