package com.ferreiraluizga.infrastructure.presentation;

import com.ferreiraluizga.entities.Turma;
import com.ferreiraluizga.infrastructure.dtos.request.TurmaRequest;
import com.ferreiraluizga.infrastructure.dtos.response.TurmaResponse;
import com.ferreiraluizga.infrastructure.mappers.turma.TurmaDtoMapper;
import com.ferreiraluizga.usecases.turma.BuscarTurmaPorIdUseCase;
import com.ferreiraluizga.usecases.turma.ExcluirTurmaUseCase;
import com.ferreiraluizga.usecases.turma.ListarTurmasUseCase;
import com.ferreiraluizga.usecases.turma.SalvarTurmaUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/turmas")
@RequiredArgsConstructor
public class TurmaController {

    private final SalvarTurmaUseCase salvarTurmaUseCase;
    private final ListarTurmasUseCase listarTurmasUseCase;
    private final BuscarTurmaPorIdUseCase buscarTurmaPorIdUseCase;
    private final ExcluirTurmaUseCase excluirTurmaUseCase;
    private final TurmaDtoMapper turmaDtoMapper;

    @PostMapping
    public ResponseEntity<TurmaResponse> salvarTurma(@Valid @RequestBody TurmaRequest dto) {
        Turma response = salvarTurmaUseCase.execute(turmaDtoMapper.toDomain(dto));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(turmaDtoMapper.toResponse(response));
    }

    @GetMapping
    public ResponseEntity<List<TurmaResponse>> listarTurmas() {
        List<Turma> response = listarTurmasUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK)
                .body(response.stream()
                        .map(turmaDtoMapper::toResponse)
                        .collect(Collectors.toList())
                );
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurmaResponse> buscarTurmaPorId(@PathVariable Long id) {
        Turma response = buscarTurmaPorIdUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(turmaDtoMapper.toResponse(response));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TurmaResponse> excluirTurma(@PathVariable Long id) {
        excluirTurmaUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }

}
