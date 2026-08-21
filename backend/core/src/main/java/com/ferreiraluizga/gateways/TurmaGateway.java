package com.ferreiraluizga.gateways;

import com.ferreiraluizga.entities.Turma;

import java.util.List;
import java.util.Optional;

public interface TurmaGateway {

    Turma salvarTurma(Turma turma);

    List<Turma> listarTurmas();

    Optional<Turma> buscarTurmaPorId(Long id);

    void excluirTurma(Long id);

}
