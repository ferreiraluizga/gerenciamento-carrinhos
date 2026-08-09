package com.ferreiraluizga.infrastructure.presentation;

import com.ferreiraluizga.entities.Ocorrencia;
import com.ferreiraluizga.infrastructure.dtos.request.OcorrenciaFecharRequest;
import com.ferreiraluizga.infrastructure.dtos.request.OcorrenciaManutencaoRequest;
import com.ferreiraluizga.infrastructure.dtos.request.OcorrenciaRequest;
import com.ferreiraluizga.infrastructure.dtos.response.OcorrenciaResponse;
import com.ferreiraluizga.infrastructure.mappers.ocorrencia.OcorrenciaDtoMapper;
import com.ferreiraluizga.usecases.ocorrencia.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/ocorrencias")
@RequiredArgsConstructor
public class OcorrenciaController {

    private final OcorrenciaDtoMapper ocorrenciaDtoMapper;
    private final SalvarOcorrenciaUseCase salvarOcorrenciaUseCase;
    private final ListarOcorrenciasUseCase listarOcorrenciasUseCase;
    private final BuscarOcorrenciaPorIdUseCase buscarOcorrenciaPorIdUseCase;
    private final DefinirOcorrenciaManutencaoUseCase definirOcorrenciaManutencaoUseCase;
    private final FecharOcorrenciaUseCase fecharOcorrenciaUseCase;
    private final ExcluirOcorrenciaUseCase excluirOcorrenciaUseCase;

    @PostMapping
    public ResponseEntity<OcorrenciaResponse> salvarOcorrencia(@Valid @RequestBody OcorrenciaRequest dto) {
        Ocorrencia response = salvarOcorrenciaUseCase.execute(ocorrenciaDtoMapper.toDomain(dto));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ocorrenciaDtoMapper.toDto(response));
    }

    @GetMapping
    public ResponseEntity<List<OcorrenciaResponse>> listarOcorrencia() {
        List<Ocorrencia> response = listarOcorrenciasUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK)
                .body(response.stream()
                        .map(ocorrenciaDtoMapper::toDto)
                        .collect(Collectors.toList())
                );
    }

    @GetMapping("/{id}")
    public ResponseEntity<OcorrenciaResponse> buscarOcorrenciaPorId(@PathVariable Long id) {
        Ocorrencia response = buscarOcorrenciaPorIdUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ocorrenciaDtoMapper.toDto(response));
    }

    @PutMapping("/definir-manutencao/{id}")
    public ResponseEntity<OcorrenciaResponse> definirOcorrenciaManutencao(@PathVariable Long id, @RequestBody OcorrenciaManutencaoRequest dto) {
        Ocorrencia response = definirOcorrenciaManutencaoUseCase.execute(id, dto.observacao());
        return ResponseEntity.status(HttpStatus.OK)
                .body(ocorrenciaDtoMapper.toDto(response));
    }

    @PutMapping("/fechar-ocorrencia/{id}")
    public ResponseEntity<OcorrenciaResponse> fecharOcorrencia(@PathVariable Long id, @RequestBody OcorrenciaFecharRequest dto) {
        Ocorrencia response = fecharOcorrenciaUseCase.execute(id, dto.feedback());
        return ResponseEntity.status(HttpStatus.OK)
                .body(ocorrenciaDtoMapper.toDto(response));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirOcorrencia(@PathVariable Long id) {
        excluirOcorrenciaUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }

}
