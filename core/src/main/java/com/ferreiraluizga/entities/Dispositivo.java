package com.ferreiraluizga.entities;

import com.ferreiraluizga.enums.ModeloDispositivo;
import com.ferreiraluizga.enums.SistemaOperacional;

import java.util.List;

public record Dispositivo(
        Long id,
        String serial,
        Integer numDispositivo,
        ModeloDispositivo modeloDispositivo,
        SistemaOperacional sistemaOperacional,
        Boolean ativo,
        String observacao,
        Boolean manutencao,
        Carrinho carrinho,
        List<Ocorrencia> ocorrencias
) { }
