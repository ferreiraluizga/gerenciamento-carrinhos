package com.ferreiraluizga.usecases.turma;

import com.ferreiraluizga.entities.Turma;
import com.ferreiraluizga.gateways.TurmaGateway;

public class SalvarTurmaUseCaseImpl implements SalvarTurmaUseCase{

    private final TurmaGateway turmaGateway;

    public SalvarTurmaUseCaseImpl(TurmaGateway turmaGateway) {
        this.turmaGateway = turmaGateway;
    }

    @Override
    public Turma execute(Turma turma) {
        return turmaGateway.salvarTurma(turma);
    }

}
