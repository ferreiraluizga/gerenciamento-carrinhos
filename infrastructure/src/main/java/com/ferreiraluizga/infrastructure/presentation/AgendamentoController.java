package com.ferreiraluizga.infrastructure.presentation;

import com.ferreiraluizga.entities.Agendamento;
import com.ferreiraluizga.infrastructure.dtos.request.AgendamentoRequest;
import com.ferreiraluizga.infrastructure.dtos.response.AgendamentoResponse;
import com.ferreiraluizga.infrastructure.mappers.agendamento.AgendamentoDtoMapper;
import com.ferreiraluizga.usecases.agendamento.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoDtoMapper agendamentoDtoMapper;
    private final SalvarAgendamentoUseCase salvarAgendamentoUseCase;
    private final ListarAgendamentosUseCase listarAgendamentosUseCase;
    private final BuscarAgendamentoPorIdUseCase buscarAgendamentoPorIdUseCase;
    private final DefinirAgendamentoFixoUseCase definirAgendamentoFixoUseCase;
    private final ExcluirAgendamentoUseCase excluirAgendamentoUseCase;

    @PostMapping
    public ResponseEntity<AgendamentoResponse> salvarAgendamento(@Valid @RequestBody AgendamentoRequest dto) {
        Agendamento response = salvarAgendamentoUseCase.execute(agendamentoDtoMapper.toDomain(dto));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(agendamentoDtoMapper.toDto(response));
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoResponse>> listarAgendamentos() {
        List<Agendamento> response = listarAgendamentosUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK)
                .body(response.stream()
                        .map(agendamentoDtoMapper::toDto)
                        .collect(Collectors.toList())
                );
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoResponse> buscarAgendamentoPorId(@PathVariable Long id) {
        Agendamento response = buscarAgendamentoPorIdUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(agendamentoDtoMapper.toDto(response));
    }

    @PutMapping("/definir-fixo/{id}")
    public ResponseEntity<AgendamentoResponse> definirAgendamentoFixo(@PathVariable Long id) {
        Agendamento response = definirAgendamentoFixoUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(agendamentoDtoMapper.toDto(response));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AgendamentoResponse> excluirAgendamento(@PathVariable Long id) {
        excluirAgendamentoUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }

}
