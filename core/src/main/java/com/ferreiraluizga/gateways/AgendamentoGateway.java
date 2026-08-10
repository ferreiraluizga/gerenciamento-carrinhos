package com.ferreiraluizga.gateways;

import com.ferreiraluizga.entities.Agendamento;

import java.util.List;
import java.util.Optional;

public interface AgendamentoGateway {

    Agendamento salvarAgendamento(Agendamento agendamento);

    List<Agendamento> listarAgendamentos();

    Optional<Agendamento> buscarAgendamentoPorId(Long id);

    void excluirAgendamento(Long id);

}
