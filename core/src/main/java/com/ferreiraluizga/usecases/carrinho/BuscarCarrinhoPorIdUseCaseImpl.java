package com.ferreiraluizga.usecases.carrinho;

import com.ferreiraluizga.entities.Carrinho;
import com.ferreiraluizga.gateways.CarrinhoGateway;

import java.util.Optional;

public class BuscarCarrinhoPorIdUseCaseImpl implements BuscarCarrinhoPorIdUseCase {

    private final CarrinhoGateway carrinhoGateway;

    public BuscarCarrinhoPorIdUseCaseImpl(CarrinhoGateway carrinhoGateway) {
        this.carrinhoGateway = carrinhoGateway;
    }

    @Override
    public Optional<Carrinho> execute(Long id) {
        return carrinhoGateway.buscarCarrinhoPorId(id);
    }

}
