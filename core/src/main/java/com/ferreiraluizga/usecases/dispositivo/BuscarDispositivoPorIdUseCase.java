package com.ferreiraluizga.usecases.dispositivo;

import com.ferreiraluizga.entities.Dispositivo;

import java.util.Optional;

public interface BuscarDispositivoPorIdUseCase {

    Dispositivo execute(Long id);

}
