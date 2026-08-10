package com.ferreiraluizga.usecases.agendamento;

import com.ferreiraluizga.entities.Agendamento;

public interface BuscarAgendamentoPorIdUseCase {

    Agendamento execute(Long id);

}
