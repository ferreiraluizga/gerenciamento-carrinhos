package com.ferreiraluizga.usecases.turma;

import com.ferreiraluizga.gateways.TurmaGateway;

public class ExcluirTurmaUseCaseImpl implements ExcluirTurmaUseCase {

    private final TurmaGateway turmaGateway;

    public ExcluirTurmaUseCaseImpl(TurmaGateway turmaGateway) {
        this.turmaGateway = turmaGateway;
    }

    @Override
    public void execute(Long id) {
        turmaGateway.excluirTurma(id);
    }

}
