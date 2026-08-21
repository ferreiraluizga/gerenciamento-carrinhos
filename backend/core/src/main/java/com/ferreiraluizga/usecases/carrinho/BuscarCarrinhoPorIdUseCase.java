package com.ferreiraluizga.usecases.carrinho;

import com.ferreiraluizga.entities.Carrinho;

public interface BuscarCarrinhoPorIdUseCase {

    Carrinho execute(Long id);

}
