package com.ferreiraluizga.entities;

import com.ferreiraluizga.enums.Turno;

import java.util.List;

public record Turma(
        Long id,
        String nome,
        Turno turno,
        List<Agendamento> agendamentos
) { }
