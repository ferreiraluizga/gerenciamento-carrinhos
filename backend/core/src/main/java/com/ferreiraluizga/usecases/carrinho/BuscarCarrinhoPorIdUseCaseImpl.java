package com.ferreiraluizga.usecases.carrinho;

import com.ferreiraluizga.entities.Carrinho;
import com.ferreiraluizga.exceptions.carrinho.CarrinhoNaoEncontrado;
import com.ferreiraluizga.gateways.CarrinhoGateway;

public class BuscarCarrinhoPorIdUseCaseImpl implements BuscarCarrinhoPorIdUseCase {

    private final CarrinhoGateway carrinhoGateway;

    public BuscarCarrinhoPorIdUseCaseImpl(CarrinhoGateway carrinhoGateway) {
        this.carrinhoGateway = carrinhoGateway;
    }

    @Override
    public Carrinho execute(Long id) {
        return carrinhoGateway.buscarCarrinhoPorId(id)
                .orElseThrow(() -> new CarrinhoNaoEncontrado(id));
    }

}
