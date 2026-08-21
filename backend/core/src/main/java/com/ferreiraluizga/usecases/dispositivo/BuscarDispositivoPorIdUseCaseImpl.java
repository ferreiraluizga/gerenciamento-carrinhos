package com.ferreiraluizga.usecases.dispositivo;

import com.ferreiraluizga.entities.Dispositivo;
import com.ferreiraluizga.exceptions.dispositivo.DispositivoNaoEncontrado;
import com.ferreiraluizga.gateways.DispositivoGateway;

public class BuscarDispositivoPorIdUseCaseImpl implements BuscarDispositivoPorIdUseCase{

    private final DispositivoGateway dispositivoGateway;

    public BuscarDispositivoPorIdUseCaseImpl(DispositivoGateway dispositivoGateway) {
        this.dispositivoGateway = dispositivoGateway;
    }

    @Override
    public Dispositivo execute(Long id) {
        return dispositivoGateway.buscarDispositivoPorId(id)
                .orElseThrow(() -> new DispositivoNaoEncontrado(id));
    }

}
