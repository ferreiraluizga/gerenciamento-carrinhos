package com.ferreiraluizga.dtos.request;

import jakarta.validation.constraints.NotBlank;

public record CarrinhoRequest(
        @NotBlank String descricao
) { }
