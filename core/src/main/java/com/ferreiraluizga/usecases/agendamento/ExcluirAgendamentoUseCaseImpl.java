package com.ferreiraluizga.usecases.agendamento;

import com.ferreiraluizga.gateways.AgendamentoGateway;

public class ExcluirAgendamentoUseCaseImpl implements ExcluirAgendamentoUseCase {

    private final AgendamentoGateway agendamentoGateway;

    public ExcluirAgendamentoUseCaseImpl(AgendamentoGateway agendamentoGateway) {
        this.agendamentoGateway = agendamentoGateway;
    }

    @Override
    public void execute(Long id) {
        agendamentoGateway.excluirAgendamento(id);
    }

}
