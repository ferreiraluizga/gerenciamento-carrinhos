package com.ferreiraluizga.entities;

import java.util.List;

public record Carrinho(
        Long id,
        String descricao,
        List<Dispositivo> dispositivos,
        List<Agendamento> agendamentos
) { }
