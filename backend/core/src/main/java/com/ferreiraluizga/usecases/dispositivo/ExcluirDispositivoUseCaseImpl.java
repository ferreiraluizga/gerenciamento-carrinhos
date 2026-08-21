package com.ferreiraluizga.usecases.dispositivo;

import com.ferreiraluizga.gateways.DispositivoGateway;

public class ExcluirDispositivoUseCaseImpl implements ExcluirDispositivoUseCase{

    private final DispositivoGateway dispositivoGateway;

    public ExcluirDispositivoUseCaseImpl(DispositivoGateway dispositivoGateway) {
        this.dispositivoGateway = dispositivoGateway;
    }

    @Override
    public void execute(Long id) {
        dispositivoGateway.excluirDispositivo(id);
    }

}
