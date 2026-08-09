package com.ferreiraluizga.infrastructure.gateways;

import com.ferreiraluizga.entities.Ocorrencia;
import com.ferreiraluizga.gateways.OcorrenciaGateway;
import com.ferreiraluizga.infrastructure.mappers.ocorrencia.OcorrenciaEntityMapper;
import com.ferreiraluizga.infrastructure.persistence.ocorrencia.OcorrenciaEntity;
import com.ferreiraluizga.infrastructure.persistence.ocorrencia.OcorrenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OcorrenciaRepositoryGateway implements OcorrenciaGateway {

    private final OcorrenciaRepository ocorrenciaRepository;
    private final OcorrenciaEntityMapper ocorrenciaEntityMapper;

    @Override
    public Ocorrencia salvarOcorrencia(Ocorrencia ocorrencia) {
        OcorrenciaEntity entityResponse = ocorrenciaRepository.save(ocorrenciaEntityMapper.toEntity(ocorrencia));
        return ocorrenciaEntityMapper.toDomain(entityResponse);
    }

    @Override
    public List<Ocorrencia> listarOcorrencias() {
        return ocorrenciaRepository.findAll().stream()
                .map(ocorrenciaEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Ocorrencia> buscarOcorrenciaPorId(Long id) {
        return ocorrenciaRepository.findById(id)
                .map(ocorrenciaEntityMapper::toDomain);
    }

    @Override
    public void excluirOcorrencia(Long id) {
        ocorrenciaRepository.deleteById(id);
    }
}
