package com.ferreiraluizga.infrastructure.mappers.dispositivo;

import com.ferreiraluizga.entities.Dispositivo;
import com.ferreiraluizga.infrastructure.dtos.request.DispositivoRequest;
import com.ferreiraluizga.infrastructure.dtos.response.DispositivoResponse;
import org.springframework.stereotype.Component;

@Component
public class DispositivoDtoMapper {

    // dto -> domain
    public Dispositivo toDomain(DispositivoRequest dto) {
        return new Dispositivo(
                null,
                dto.serial(),
                dto.numDispositivo(),
                dto.modeloDispositivo(),
                dto.sistemaOperacional(),
                dto.ativo(),
                dto.observacao(),
                dto.manutencao()
        );
    }

    // dto -> domain (put)
    public Dispositivo toDomain(Long id, DispositivoRequest dto) {
        return new Dispositivo(
                id,
                dto.serial(),
                dto.numDispositivo(),
                dto.modeloDispositivo(),
                dto.sistemaOperacional(),
                dto.ativo(),
                dto.observacao(),
                dto.manutencao()
        );
    }

    // domain -> dto
    public DispositivoResponse toDto(Dispositivo dispositivo) {
        return new DispositivoResponse(
                dispositivo.id(),
                dispositivo.serial(),
                dispositivo.numDispositivo(),
                dispositivo.modeloDispositivo(),
                dispositivo.sistemaOperacional(),
                dispositivo.ativo(),
                dispositivo.observacao(),
                dispositivo.manutencao()
        );
    }

}
