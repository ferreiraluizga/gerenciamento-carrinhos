package com.ferreiraluizga.usecases.agendamento;

import com.ferreiraluizga.entities.Agendamento;

public interface BuscarConflitoAgendamentoUseCase {

    boolean execute(Agendamento agendamento);

}
