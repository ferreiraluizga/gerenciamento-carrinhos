package com.ferreiraluizga.usecases.agendamento;

import com.ferreiraluizga.entities.Agendamento;
import com.ferreiraluizga.exceptions.agendamento.AgendamentoNaoEncontrado;
import com.ferreiraluizga.gateways.AgendamentoGateway;

public class DefinirAgendamentoFixoUseCaseImpl implements DefinirAgendamentoFixoUseCase {

    private final AgendamentoGateway agendamentoGateway;

    public DefinirAgendamentoFixoUseCaseImpl(AgendamentoGateway agendamentoGateway) {
        this.agendamentoGateway = agendamentoGateway;
    }

    @Override
    public Agendamento execute(Long id) {
        Agendamento agendamento = agendamentoGateway.buscarAgendamentoPorId(id)
                .orElseThrow(() -> new AgendamentoNaoEncontrado(id));

        return agendamentoGateway.salvarAgendamento(agendamento.salvarAgendamentoFixo());
    }

}
