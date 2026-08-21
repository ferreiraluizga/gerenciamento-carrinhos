package com.ferreiraluizga.dtos.request;

import com.ferreiraluizga.enums.ModeloDispositivo;
import com.ferreiraluizga.enums.SistemaOperacional;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DispositivoRequest(
        @NotBlank String serial,
        @Min(0) Integer numDispositivo,
        @NotNull ModeloDispositivo modeloDispositivo,
        SistemaOperacional sistemaOperacional,
        @NotNull Boolean ativo,
        String observacao,
        @NotNull Boolean manutencao,
        @NotNull Long carrinhoId
) { }
