package com.ferreiraluizga.infrastructure.config.beans;

import com.ferreiraluizga.gateways.TurmaGateway;
import com.ferreiraluizga.usecases.turma.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TurmaBeanConfiguration {

    @Bean
    public SalvarTurmaUseCase salvarTurmaUseCase(TurmaGateway turmaGateway) {
        return new SalvarTurmaUseCaseImpl(turmaGateway);
    }

    @Bean
    public ListarTurmasUseCase listarTurmasUseCase(TurmaGateway turmaGateway) {
        return new ListarTurmasUseCaseImpl(turmaGateway);
    }

    @Bean
    public BuscarTurmaPorIdUseCase buscarTurmaPorIdUseCase(TurmaGateway turmaGateway) {
        return new BuscarTurmaPorIdUseCaseImpl(turmaGateway);
    }

    @Bean
    public ExcluirTurmaUseCase excluirTurmaUseCase(TurmaGateway turmaGateway) {
        return new ExcluirTurmaUseCaseImpl(turmaGateway);
    }

}
