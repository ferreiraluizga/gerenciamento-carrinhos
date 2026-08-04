package com.ferreiraluizga.exceptions;

public class CarrinhoNaoEncontrado extends RuntimeException {
    public CarrinhoNaoEncontrado(Long id) {
        super("O carrinho " + id + " não foi encontrado");
    }
}
