package com.ferreiraluizga.usecases.agendamento;

import com.ferreiraluizga.entities.Agendamento;
import com.ferreiraluizga.gateways.AgendamentoGateway;

import java.util.List;

public class ListarAgendamentosUseCaseImpl implements ListarAgendamentosUseCase{

    private final AgendamentoGateway agendamentoGateway;

    public ListarAgendamentosUseCaseImpl(AgendamentoGateway agendamentoGateway) {
        this.agendamentoGateway = agendamentoGateway;
    }

    @Override
    public List<Agendamento> execute() {
        return agendamentoGateway.listarAgendamentos();
    }

}
