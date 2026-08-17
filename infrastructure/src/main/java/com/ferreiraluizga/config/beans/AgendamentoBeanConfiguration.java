package com.ferreiraluizga.config.beans;

import com.ferreiraluizga.gateways.AgendamentoGateway;
import com.ferreiraluizga.usecases.agendamento.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AgendamentoBeanConfiguration {

    @Bean
    public SalvarAgendamentoUseCase salvarAgendamentoUseCase(AgendamentoGateway agendamentoGateway) {
        return new SalvarAgendamentoUseCaseImpl(agendamentoGateway);
    }

    @Bean
    public ListarAgendamentosUseCase listarAgendamentosUseCase(AgendamentoGateway agendamentoGateway) {
        return new ListarAgendamentosUseCaseImpl(agendamentoGateway);
    }

    @Bean
    public BuscarAgendamentoPorIdUseCase buscarAgendamentoPorIdUseCase(AgendamentoGateway agendamentoGateway) {
        return new BuscarAgendamentoPorIdUseCaseImpl(agendamentoGateway);
    }

    @Bean
    public DefinirAgendamentoFixoUseCase definirAgendamentoFixoUseCase(AgendamentoGateway agendamentoGateway) {
        return new DefinirAgendamentoFixoUseCaseImpl(agendamentoGateway);
    }

    @Bean
    public ExcluirAgendamentoUseCase excluirAgendamentoUseCase(AgendamentoGateway agendamentoGateway) {
        return new ExcluirAgendamentoUseCaseImpl(agendamentoGateway);
    }

}
