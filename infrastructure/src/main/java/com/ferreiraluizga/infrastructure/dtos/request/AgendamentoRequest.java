package com.ferreiraluizga.infrastructure.dtos.request;

import com.ferreiraluizga.enums.Aula;
import com.ferreiraluizga.enums.DiaDaSemana;
import com.ferreiraluizga.enums.TipoAgendamento;

import java.time.LocalDateTime;

public record AgendamentoRequest(
        String professor,
        Long carrinhoId,
        TipoAgendamento tipoAgendamento,
        Long turmaId,
        Aula aula,
        LocalDateTime data,
        DiaDaSemana diaDaSemana
) { }
