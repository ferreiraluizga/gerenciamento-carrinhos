package com.ferreiraluizga.usecases.carrinho;

import com.ferreiraluizga.entities.Carrinho;
import com.ferreiraluizga.gateways.CarrinhoGateway;

import java.util.List;

public class ListarCarrinhosUseCaseImpl implements ListarCarrinhosUseCase {

    private final CarrinhoGateway carrinhoGateway;

    public ListarCarrinhosUseCaseImpl(CarrinhoGateway carrinhoGateway) {
        this.carrinhoGateway = carrinhoGateway;
    }

    @Override
    public List<Carrinho> execute() {
        return carrinhoGateway.listarCarrinhos();
    }

}
