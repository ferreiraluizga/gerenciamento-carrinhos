package com.ferreiraluizga.infrastructure.dtos.request;

import com.ferreiraluizga.enums.ModeloDispositivo;
import com.ferreiraluizga.enums.SistemaOperacional;

public record DispositivoRequest(
        String serial,
        Integer numDispositivo,
        ModeloDispositivo modeloDispositivo,
        SistemaOperacional sistemaOperacional,
        Boolean ativo,
        String observacao,
        Boolean manutencao,
        Long carrinhoId
) { }
