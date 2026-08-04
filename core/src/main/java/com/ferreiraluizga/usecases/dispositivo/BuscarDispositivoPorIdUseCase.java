package com.ferreiraluizga.usecases.dispositivo;

import com.ferreiraluizga.entities.Dispositivo;

import java.util.Optional;

public interface BuscarDispositivoPorIdUseCase {

    Optional<Dispositivo> execute(Long id);

}
