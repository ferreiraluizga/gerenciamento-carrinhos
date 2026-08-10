package com.ferreiraluizga.entities;

import com.ferreiraluizga.enums.Aula;
import com.ferreiraluizga.enums.DiaDaSemana;
import com.ferreiraluizga.enums.TipoAgendamento;

import java.time.LocalDateTime;

public record Agendamento(
        Long id,
        String professor,
        Carrinho carrinho,
        TipoAgendamento tipoAgendamento,
        Turma turma,
        Aula aula,
        LocalDateTime data,
        DiaDaSemana diaDaSemana
) {

    public Agendamento salvarAgendamentoFixo() {
        return new Agendamento(
                this.id(),
                this.professor(),
                this.carrinho(),
                TipoAgendamento.FIXO,
                this.turma(),
                this.aula(),
                null,
                this.diaDaSemana()
        );
    }

    public Agendamento salvarAgendamentoComum() {
        return new Agendamento(
                this.id(),
                this.professor(),
                this.carrinho(),
                TipoAgendamento.COMUM,
                this.turma(),
                this.aula(),
                this.data(),
                null
        );
    }
}
