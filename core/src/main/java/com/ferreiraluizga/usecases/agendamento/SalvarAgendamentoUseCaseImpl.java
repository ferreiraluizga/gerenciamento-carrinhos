package com.ferreiraluizga.usecases.agendamento;

import com.ferreiraluizga.entities.Agendamento;
import com.ferreiraluizga.enums.TipoAgendamento;
import com.ferreiraluizga.exceptions.agendamento.ConflitoAgendamento;
import com.ferreiraluizga.gateways.AgendamentoGateway;

public class SalvarAgendamentoUseCaseImpl implements SalvarAgendamentoUseCase {

    private final AgendamentoGateway agendamentoGateway;
    private final BuscarConflitoAgendamentoUseCase buscarConflitoAgendamentoUseCase;

    public SalvarAgendamentoUseCaseImpl(AgendamentoGateway agendamentoGateway, BuscarConflitoAgendamentoUseCase buscarConflitoAgendamentoUseCase) {
        this.agendamentoGateway = agendamentoGateway;
        this.buscarConflitoAgendamentoUseCase = buscarConflitoAgendamentoUseCase;
    }

    @Override
    public Agendamento execute(Agendamento agendamento) {
        if (buscarConflitoAgendamentoUseCase.execute(agendamento)) {
            throw new ConflitoAgendamento();
        }

        if (agendamento.tipoAgendamento() == TipoAgendamento.COMUM) {
            return agendamentoGateway.salvarAgendamento(agendamento.salvarAgendamentoComum());
        } else {
            return agendamentoGateway.salvarAgendamento(agendamento.salvarAgendamentoFixo());
        }
    }
}
