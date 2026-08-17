package com.ferreiraluizga.mappers.dispositivo;

import com.ferreiraluizga.entities.Carrinho;
import com.ferreiraluizga.entities.Dispositivo;
import com.ferreiraluizga.dtos.request.DispositivoRequest;
import com.ferreiraluizga.dtos.response.DispositivoResponse;
import org.springframework.stereotype.Component;

@Component
public class DispositivoDtoMapper {

    // dto -> domain
    public Dispositivo toDomain(DispositivoRequest dto) {
        Carrinho c = new Carrinho(
                dto.carrinhoId(),
                null,
                null,
                null
        );

        return new Dispositivo(
                null,
                dto.serial(),
                dto.numDispositivo(),
                dto.modeloDispositivo(),
                dto.sistemaOperacional(),
                dto.ativo(),
                dto.observacao(),
                dto.manutencao(),
                c,
                null
        );
    }

    // dto -> domain (put)
    public Dispositivo toDomain(Long id, DispositivoRequest dto) {
        Carrinho c = new Carrinho(
                dto.carrinhoId(),
                null,
                null,
                null
        );

        return new Dispositivo(
                id,
                dto.serial(),
                dto.numDispositivo(),
                dto.modeloDispositivo(),
                dto.sistemaOperacional(),
                dto.ativo(),
                dto.observacao(),
                dto.manutencao(),
                c,
                null
        );
    }

    // domain -> dto
    public DispositivoResponse toDto(Dispositivo dispositivo) {
        int quantOcorrencias = (dispositivo.ocorrencias() != null) ? dispositivo.ocorrencias().size() : 0;

        return new DispositivoResponse(
                dispositivo.id(),
                dispositivo.serial(),
                dispositivo.numDispositivo(),
                dispositivo.modeloDispositivo(),
                dispositivo.sistemaOperacional(),
                dispositivo.ativo(),
                dispositivo.observacao(),
                dispositivo.manutencao(),
                dispositivo.carrinho().id(),
                dispositivo.carrinho().descricao(),
                quantOcorrencias
        );
    }

}
