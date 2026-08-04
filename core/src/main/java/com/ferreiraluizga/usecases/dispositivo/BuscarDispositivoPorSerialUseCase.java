package com.ferreiraluizga.usecases.dispositivo;

import com.ferreiraluizga.entities.Dispositivo;

import java.util.Optional;

public interface BuscarDispositivoPorSerialUseCase {

    Optional<Dispositivo> execute(String serial);

}
