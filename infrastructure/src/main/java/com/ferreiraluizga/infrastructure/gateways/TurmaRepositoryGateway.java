package com.ferreiraluizga.infrastructure.gateways;

import com.ferreiraluizga.entities.Turma;
import com.ferreiraluizga.gateways.TurmaGateway;
import com.ferreiraluizga.infrastructure.mappers.turma.TurmaEntityMapper;
import com.ferreiraluizga.infrastructure.persistence.turma.TurmaEntity;
import com.ferreiraluizga.infrastructure.persistence.turma.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TurmaRepositoryGateway implements TurmaGateway {

    private final TurmaRepository turmaRepository;
    private final TurmaEntityMapper turmaEntityMapper;

    @Override
    public Turma salvarTurma(Turma turma) {
        TurmaEntity entityResponse = turmaRepository.save(turmaEntityMapper.toEntity(turma));
        return turmaEntityMapper.toDomain(entityResponse);
    }

    @Override
    public List<Turma> listarTurmas() {
        return turmaRepository.findAll().stream()
                .map(turmaEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Turma> buscarTurmaPorId(Long id) {
        return turmaRepository.findById(id)
                .map(turmaEntityMapper::toDomain);
    }

    @Override
    public void excluirTurma(Long id) {
        turmaRepository.deleteById(id);
    }
}
