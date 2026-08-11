package com.ferreiraluizga.infrastructure.dtos.response;

import com.ferreiraluizga.enums.Aula;
import com.ferreiraluizga.enums.DiaDaSemana;
import com.ferreiraluizga.enums.TipoAgendamento;

import java.time.LocalDateTime;

public record AgendamentoResponse(
        Long id,
        String professor,
        Long carrinhoId,
        String carrinhoDescricao,
        TipoAgendamento tipoAgendamento,
        String turmaNome,
        Aula aula,
        LocalDateTime data,
        DiaDaSemana diaDaSemana
) { }
