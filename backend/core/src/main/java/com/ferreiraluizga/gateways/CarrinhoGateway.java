package com.ferreiraluizga.gateways;

import com.ferreiraluizga.entities.Carrinho;

import java.util.List;
import java.util.Optional;

public interface CarrinhoGateway {

    Carrinho salvarCarrinho(Carrinho carrinho);

    List<Carrinho> listarCarrinhos();

    Optional<Carrinho> buscarCarrinhoPorId(Long id);

    void excluirCarrinho(Long id);

}
