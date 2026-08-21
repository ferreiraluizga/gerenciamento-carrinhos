package com.ferreiraluizga.usecases.agendamento;

import com.ferreiraluizga.entities.Agendamento;
import com.ferreiraluizga.enums.TipoAgendamento;
import com.ferreiraluizga.exceptions.agendamento.ConflitoAgendamento;
import com.ferreiraluizga.gateways.AgendamentoGateway;

import java.util.List;

public class SalvarAgendamentoUseCaseImpl implements SalvarAgendamentoUseCase {

    private final AgendamentoGateway agendamentoGateway;

    public SalvarAgendamentoUseCaseImpl(AgendamentoGateway agendamentoGateway) {
        this.agendamentoGateway = agendamentoGateway;
    }

    @Override
    public Agendamento execute(Agendamento agendamento) {
        if (buscarConflitoAgendamento(agendamento)) {
            throw new ConflitoAgendamento();
        }

        if (agendamento.tipoAgendamento() == TipoAgendamento.COMUM) {
            return agendamentoGateway.salvarAgendamento(agendamento.salvarAgendamentoComum());
        } else {
            return agendamentoGateway.salvarAgendamento(agendamento.salvarAgendamentoFixo());
        }
    }

    private boolean buscarConflitoAgendamento(Agendamento agendamento) {
        List<Agendamento> agendamentos = agendamentoGateway.listarAgendamentos();

        for (Agendamento a : agendamentos) {
            // 1. Valida se é a mesma aula/horário
            if (a.aula().equals(agendamento.aula())) {

                // 2. Valida se há conflito de calendário (Data ou Dia da Semana)
                if (verificarConflitoDeTempo(agendamento, a)) {

                    // Regra 1: O mesmo professor não pode estar em dois lugares ao mesmo tempo
                    if (a.professor().equalsIgnoreCase(agendamento.professor())) {
                        return true;
                    }

                    // Regra 2: Conflito de Carrinho - Comparando estritamente pelos IDs
                    if (a.carrinho().id().equals(agendamento.carrinho().id())) {
                        return true;
                    }

                    // Regra 3: Conflito de Turma - Comparando pelos IDs ou pelo Nome da Turma
                    if (a.turma().id().equals(agendamento.turma().id())) {
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
