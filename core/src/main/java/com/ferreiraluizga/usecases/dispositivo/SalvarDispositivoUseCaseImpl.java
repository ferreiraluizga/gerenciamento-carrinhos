package com.ferreiraluizga.usecases.dispositivo;

import com.ferreiraluizga.entities.Dispositivo;
import com.ferreiraluizga.exceptions.carrinho.CarrinhoNaoEncontrado;
import com.ferreiraluizga.exceptions.dispositivo.SerialEncontrado;
import com.ferreiraluizga.gateways.CarrinhoGateway;
import com.ferreiraluizga.gateways.DispositivoGateway;

public class SalvarDispositivoUseCaseImpl implements SalvarDispositivoUseCase {

    private final DispositivoGateway dispositivoGateway;

    private final CarrinhoGateway carrinhoGateway;

    public SalvarDispositivoUseCaseImpl(DispositivoGateway dispositivoGateway, CarrinhoGateway carrinhoGateway) {
        this.dispositivoGateway = dispositivoGateway;
        this.carrinhoGateway = carrinhoGateway;
    }

    @Override
    public Dispositivo execute(Dispositivo dispositivo) {
        dispositivoGateway.buscarDispositivoPorSerial(dispositivo.serial())
                .ifPresent(d -> { throw new SerialEncontrado(dispositivo.serial()); });
        carrinhoGateway.buscarCarrinhoPorId(dispositivo.carrinho().id())
                .orElseThrow(() -> new CarrinhoNaoEncontrado(dispositivo.carrinho().id()));
        return dispositivoGateway.salvarDispositivo(dispositivo);
    }

}
