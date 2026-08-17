package com.ferreiraluizga.gateways;

import com.ferreiraluizga.entities.Dispositivo;
import com.ferreiraluizga.mappers.dispositivo.DispositivoEntityMapper;
import com.ferreiraluizga.persistence.dispositivo.DispositivoEntity;
import com.ferreiraluizga.persistence.dispositivo.DispositivoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DispositivoRepositoryGateway implements DispositivoGateway {

    private final DispositivoEntityMapper dispositivoEntityMapper;
    private final DispositivoRepository dispositivoRepository;

    @Override
    public Dispositivo salvarDispositivo(Dispositivo dispositivo) {
        DispositivoEntity entityResponse = dispositivoRepository.save(dispositivoEntityMapper.toEntity(dispositivo));
        return dispositivoEntityMapper.toDomain(entityResponse);
    }

    @Override
    public List<Dispositivo> listarDispositivos() {
        return dispositivoRepository.findAll().stream()
                .map(dispositivoEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Dispositivo> buscarDispositivoPorId(Long id) {
        return dispositivoRepository.findById(id)
                .map(dispositivoEntityMapper::toDomain);
    }

    @Override
    public Optional<Dispositivo> buscarDispositivoPorSerial(String serial) {
        return dispositivoRepository.findBySerial(serial)
                .map(dispositivoEntityMapper::toDomain);
    }

    @Override
    public void excluirDispositivo(Long id) {
        dispositivoRepository.deleteById(id);
    }
}
