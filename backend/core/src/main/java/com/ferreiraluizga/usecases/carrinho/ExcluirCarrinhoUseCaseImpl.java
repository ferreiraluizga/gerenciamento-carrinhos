package com.ferreiraluizga.usecases.carrinho;

import com.ferreiraluizga.gateways.CarrinhoGateway;

public class ExcluirCarrinhoUseCaseImpl implements ExcluirCarrinhoUseCase {

    private final CarrinhoGateway carrinhoGateway;

    public ExcluirCarrinhoUseCaseImpl(CarrinhoGateway carrinhoGateway) {
        this.carrinhoGateway = carrinhoGateway;
    }

    @Override
    public void execute(Long id) {
        carrinhoGateway.excluirCarrinho(id);
    }

}
