package com.ferreiraluizga.usecases.turma;

import com.ferreiraluizga.entities.Turma;
import com.ferreiraluizga.gateways.TurmaGateway;

import java.util.List;

public class ListarTurmasUseCaseImpl implements ListarTurmasUseCase{

    private final TurmaGateway turmaGateway;

    public ListarTurmasUseCaseImpl(TurmaGateway turmaGateway) {
        this.turmaGateway = turmaGateway;
    }

    @Override
    public List<Turma> execute() {
        return turmaGateway.listarTurmas();
    }

}
