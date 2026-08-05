package com.ferreiraluizga.infrastructure.dtos.response;

import com.ferreiraluizga.enums.ModeloDispositivo;
import com.ferreiraluizga.enums.SistemaOperacional;

public record DispositivoResponse(
        Long id,
        String serial,
        Integer numDispositivo,
        ModeloDispositivo modeloDispositivo,
        SistemaOperacional sistemaOperacional,
        Boolean ativo,
        String observacao,
        Boolean manutencao,
        Long carrinhoId,
        String carrinhoDescricao
) { }
