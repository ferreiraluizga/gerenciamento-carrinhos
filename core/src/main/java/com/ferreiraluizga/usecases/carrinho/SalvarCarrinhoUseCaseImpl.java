package com.ferreiraluizga.usecases.carrinho;

import com.ferreiraluizga.entities.Carrinho;
import com.ferreiraluizga.gateways.CarrinhoGateway;

public class SalvarCarrinhoUseCaseImpl implements SalvarCarrinhoUseCase {

    private final CarrinhoGateway carrinhoGateway;

    public SalvarCarrinhoUseCaseImpl(CarrinhoGateway carrinhoGateway) {
        this.carrinhoGateway = carrinhoGateway;
    }

    @Override
    public Carrinho execute(Carrinho carrinho) {
        return carrinhoGateway.salvarCarrinho(carrinho);
    }

}
