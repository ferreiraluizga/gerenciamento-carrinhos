package com.ferreiraluizga.infrastructure.presentation;

import com.ferreiraluizga.entities.Dispositivo;
import com.ferreiraluizga.exceptions.dispositivo.DispositivoNaoEncontrado;
import com.ferreiraluizga.infrastructure.dtos.request.DispositivoRequest;
import com.ferreiraluizga.infrastructure.dtos.response.DispositivoResponse;
import com.ferreiraluizga.infrastructure.mappers.dispositivo.DispositivoDtoMapper;
import com.ferreiraluizga.usecases.dispositivo.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/dispositivos")
@RequiredArgsConstructor
public class DispositivoController {

    private final DispositivoDtoMapper dispositivoDtoMapper;
    private final SalvarDispositivoUseCase salvarDispositivoUseCase;
    private final ListarDispositivosUseCase listarDispositivosUseCase;
    private final BuscarDispositivoPorIdUseCase buscarDispositivoPorIdUseCase;
    private final AtualizarDispositivoUseCase atualizarDispositivoUseCase;
    private final ExcluirDispositivoUseCase excluirDispositivoUseCase;

    @PostMapping
    public ResponseEntity<DispositivoResponse> salvarDispositivo(@Valid @RequestBody DispositivoRequest dto) {
        Dispositivo response = salvarDispositivoUseCase.execute(dispositivoDtoMapper.toDomain(dto));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(dispositivoDtoMapper.toDto(response));
    }

    @GetMapping
    public ResponseEntity<List<DispositivoResponse>> listarDispositivos() {
        List<Dispositivo> response = listarDispositivosUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK)
                .body(response.stream()
                        .map(dispositivoDtoMapper::toDto)
                        .collect(Collectors.toList())
                );
    }

    @GetMapping("/{id}")
    public ResponseEntity<DispositivoResponse> buscarDispositivoPorId(@PathVariable Long id) {
        Dispositivo response = buscarDispositivoPorIdUseCase.execute(id)
                .orElseThrow(() -> new DispositivoNaoEncontrado(id));
        return ResponseEntity.status(HttpStatus.OK)
                .body(dispositivoDtoMapper.toDto(response));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DispositivoResponse> atualizarDispositivo(@PathVariable Long id, @Valid @RequestBody DispositivoRequest dto) {
        Dispositivo response = atualizarDispositivoUseCase.execute(dispositivoDtoMapper.toDomain(id, dto));
        return ResponseEntity.status(HttpStatus.OK)
                .body(dispositivoDtoMapper.toDto(response));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirDispositivo(@PathVariable Long id) {
        excluirDispositivoUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }

}
