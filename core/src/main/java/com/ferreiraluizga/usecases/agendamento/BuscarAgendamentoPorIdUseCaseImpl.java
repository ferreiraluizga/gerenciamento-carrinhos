package com.ferreiraluizga.usecases.agendamento;

import com.ferreiraluizga.entities.Agendamento;
import com.ferreiraluizga.exceptions.agendamento.AgendamentoNaoEncontrado;
import com.ferreiraluizga.gateways.AgendamentoGateway;

public class BuscarAgendamentoPorIdUseCaseImpl implements BuscarAgendamentoPorIdUseCase{

    private final AgendamentoGateway agendamentoGateway;

    public BuscarAgendamentoPorIdUseCaseImpl(AgendamentoGateway agendamentoGateway) {
        this.agendamentoGateway = agendamentoGateway;
    }

    @Override
    public Agendamento execute(Long id) {
        return agendamentoGateway.buscarAgendamentoPorId(id)
                .orElseThrow(() -> new AgendamentoNaoEncontrado(id));
    }

}
