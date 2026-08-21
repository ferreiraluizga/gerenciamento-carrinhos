package com.ferreiraluizga.usecases.dispositivo;

import com.ferreiraluizga.entities.Dispositivo;
import com.ferreiraluizga.gateways.DispositivoGateway;

import java.util.List;

public class ListarDispositivosUseCaseImpl implements ListarDispositivosUseCase {

    private final DispositivoGateway dispositivoGateway;

    public ListarDispositivosUseCaseImpl(DispositivoGateway dispositivoGateway) {
        this.dispositivoGateway = dispositivoGateway;
    }

    @Override
    public List<Dispositivo> execute() {
        return dispositivoGateway.listarDispositivos();
    }

}
