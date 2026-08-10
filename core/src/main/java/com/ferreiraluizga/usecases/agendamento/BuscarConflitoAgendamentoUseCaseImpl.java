package com.ferreiraluizga.usecases.agendamento;

import com.ferreiraluizga.entities.Agendamento;
import com.ferreiraluizga.enums.TipoAgendamento;
import com.ferreiraluizga.gateways.AgendamentoGateway;

import java.util.List;

public class BuscarConflitoAgendamentoUseCaseImpl implements BuscarConflitoAgendamentoUseCase{

    private final AgendamentoGateway agendamentoGateway;

    public BuscarConflitoAgendamentoUseCaseImpl(AgendamentoGateway agendamentoGateway) {
        this.agendamentoGateway = agendamentoGateway;
    }

    @Override
    public boolean execute(Agendamento agendamento) {
        List<Agendamento> agendamentos = agendamentoGateway.listarAgendamentos();

        for (Agendamento a : agendamentos) {
            if (a.aula().equals(agendamento.aula())) {
                if (a.professor().equals(agendamento.professor()) || a.carrinho().equals(agendamento.carrinho()) || a.turma().equals(agendamento.turma())) {
                    if (verificarConflitoDeTempo(agendamento, a)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean verificarConflitoDeTempo(Agendamento novo, Agendamento existente) {
        if (novo.tipoAgendamento() == TipoAgendamento.FIXO && existente.tipoAgendamento() == TipoAgendamento.FIXO) {
            return novo.diaDaSemana().equals(existente.diaDaSemana());
        }

        if (novo.tipoAgendamento() == TipoAgendamento.COMUM && existente.tipoAgendamento() == TipoAgendamento.COMUM) {
            return novo.data().toLocalDate().equals(existente.data().toLocalDate());
        }

        if (novo.tipoAgendamento() == TipoAgendamento.COMUM && existente.tipoAgendamento() == TipoAgendamento.FIXO) {
            return novo.data().getDayOfWeek().equals(existente.diaDaSemana().toJavaDayOfWeek());
        }

        if (novo.tipoAgendamento() == TipoAgendamento.FIXO && existente.tipoAgendamento() == TipoAgendamento.COMUM) {
            return existente.data().getDayOfWeek().equals(novo.diaDaSemana().toJavaDayOfWeek());
        }

        return false;
    }

}
