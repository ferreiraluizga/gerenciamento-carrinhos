package com.ferreiraluizga.infrastructure.dtos.request;

import com.ferreiraluizga.enums.Aula;
import com.ferreiraluizga.enums.DiaDaSemana;
import com.ferreiraluizga.enums.TipoAgendamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AgendamentoRequest(
        @NotBlank String professor,
        @NotNull Long carrinhoId,
        @NotNull TipoAgendamento tipoAgendamento,
        @NotNull Long turmaId,
        @NotNull Aula aula,
        LocalDateTime data,
        DiaDaSemana diaDaSemana
) { }
