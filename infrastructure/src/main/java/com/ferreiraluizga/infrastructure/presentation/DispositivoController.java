package com.ferreiraluizga.infrastructure.presentation;

import com.ferreiraluizga.infrastructure.dtos.response.DispositivoResponse;
import com.ferreiraluizga.infrastructure.mappers.dispositivo.DispositivoDtoMapper;
import com.ferreiraluizga.usecases.dispositivo.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/dispositivos")
@RequiredArgsConstructor
public class DispositivoController {

    private DispositivoDtoMapper dispositivoDtoMapper;
    private SalvarDispositivoUseCase salvarDispositivoUseCase;
    private ListarDispositivosUseCase listarDispositivosUseCase;
    private BuscarDispositivoPorIdUseCase buscarDispositivoPorIdUseCase;
    private BuscarDispositivoPorSerialUseCase buscarDispositivoPorSerialUseCase;
    private AtualizarDispositivoUseCase atualizarDispositivoUseCase;
    private ExcluirDispositivoUseCase excluirDispositivoUseCase;

}
