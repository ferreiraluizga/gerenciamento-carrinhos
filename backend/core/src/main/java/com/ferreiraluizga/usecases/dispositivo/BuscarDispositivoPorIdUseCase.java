package com.ferreiraluizga.usecases.dispositivo;

import com.ferreiraluizga.entities.Dispositivo;

public interface BuscarDispositivoPorIdUseCase {

    Dispositivo execute(Long id);

}
