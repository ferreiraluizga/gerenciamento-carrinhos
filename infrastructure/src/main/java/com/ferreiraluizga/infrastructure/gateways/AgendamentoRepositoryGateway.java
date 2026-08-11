package com.ferreiraluizga.infrastructure.gateways;

import com.ferreiraluizga.entities.Agendamento;
import com.ferreiraluizga.gateways.AgendamentoGateway;
import com.ferreiraluizga.infrastructure.mappers.agendamento.AgendamentoEntityMapper;
import com.ferreiraluizga.infrastructure.persistence.agendamento.AgendamentoEntity;
import com.ferreiraluizga.infrastructure.persistence.agendamento.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AgendamentoRepositoryGateway implements AgendamentoGateway {

    private final AgendamentoRepository agendamentoRepository;
    private final AgendamentoEntityMapper agendamentoEntityMapper;

    @Override
    public Agendamento salvarAgendamento(Agendamento agendamento) {
        AgendamentoEntity entityResponse = agendamentoRepository.save(agendamentoEntityMapper.toEntity(agendamento));
        return agendamentoEntityMapper.toDomain(entityResponse);
    }

    @Override
    public List<Agendamento> listarAgendamentos() {
        return agendamentoRepository.findAll().stream()
                .map(agendamentoEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Agendamento> buscarAgendamentoPorId(Long id) {
        return agendamentoRepository.findById(id)
                .map(agendamentoEntityMapper::toDomain);
    }

    @Override
    public void excluirAgendamento(Long id) {
        agendamentoRepository.deleteById(id);
    }
}
