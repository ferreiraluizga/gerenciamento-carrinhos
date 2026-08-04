package com.ferreiraluizga.usecases.carrinho;

import com.ferreiraluizga.entities.Carrinho;

import java.util.Optional;

public interface BuscarCarrinhoPorIdUseCase {

    Optional<Carrinho> execute(Long id);

}
