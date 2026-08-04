package com.ferreiraluizga.entities;

import com.ferreiraluizga.enums.ModeloDispositivo;
import com.ferreiraluizga.enums.SistemaOperacional;

public record Dispositivo(
        Long id,
        String serial,
        Integer numDispositivo,
        ModeloDispositivo modeloDispositivo,
        SistemaOperacional sistemaOperacional,
        Boolean ativo,
        String observacao,
        Boolean manutencao,
        String observacaoManutencao
) { }
