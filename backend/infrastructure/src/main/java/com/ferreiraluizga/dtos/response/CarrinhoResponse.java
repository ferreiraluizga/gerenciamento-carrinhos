package com.ferreiraluizga.dtos.response;

public record CarrinhoResponse(
        Long id,
        String descricao,
        Integer quantDispositivos
) { }
