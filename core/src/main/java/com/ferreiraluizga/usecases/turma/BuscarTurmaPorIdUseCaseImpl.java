package com.ferreiraluizga.usecases.turma;

import com.ferreiraluizga.entities.Turma;
import com.ferreiraluizga.exceptions.turma.TurmaNaoEncontrada;
import com.ferreiraluizga.gateways.TurmaGateway;

public class BuscarTurmaPorIdUseCaseImpl implements BuscarTurmaPorIdUseCase{

    private final TurmaGateway turmaGateway;

    public BuscarTurmaPorIdUseCaseImpl(TurmaGateway turmaGateway) {
        this.turmaGateway = turmaGateway;
    }

    @Override
    public Turma execute(Long id) {
        return turmaGateway.buscarTurmaPorId(id)
                .orElseThrow(() -> new TurmaNaoEncontrada(id));
    }

}
