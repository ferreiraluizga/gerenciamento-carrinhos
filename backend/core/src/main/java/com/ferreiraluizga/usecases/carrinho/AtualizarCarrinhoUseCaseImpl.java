package com.ferreiraluizga.usecases.carrinho;

import com.ferreiraluizga.entities.Carrinho;
import com.ferreiraluizga.exceptions.carrinho.CarrinhoNaoEncontrado;
import com.ferreiraluizga.gateways.CarrinhoGateway;

public class AtualizarCarrinhoUseCaseImpl implements AtualizarCarrinhoUseCase {

    private final CarrinhoGateway carrinhoGateway;

    public AtualizarCarrinhoUseCaseImpl(CarrinhoGateway carrinhoGateway) {
        this.carrinhoGateway = carrinhoGateway;
    }

    @Override
    public Carrinho execute(Carrinho carrinho) {
        carrinhoGateway.buscarCarrinhoPorId(carrinho.id())
                .orElseThrow(() -> new CarrinhoNaoEncontrado(carrinho.id()));

        return carrinhoGateway.salvarCarrinho(carrinho);
    }

}
