package com.ferreiraluizga.gateways;

import com.ferreiraluizga.entities.Dispositivo;

import java.util.List;
import java.util.Optional;

public interface DispositivoGateway {

    Dispositivo salvarDispositivo(Dispositivo dispositivo);

    List<Dispositivo> listarDispositivos();

    Optional<Dispositivo> buscarDispositivoPorId(Long id);

    Optional<Dispositivo> buscarDispositivoPorSerial(String serial);

    void excluirDispositivo(Long id);

}
