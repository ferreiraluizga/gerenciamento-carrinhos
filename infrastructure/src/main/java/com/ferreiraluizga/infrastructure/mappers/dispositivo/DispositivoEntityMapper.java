package com.ferreiraluizga.infrastructure.mappers.dispositivo;

import com.ferreiraluizga.entities.Carrinho;
import com.ferreiraluizga.entities.Dispositivo;
import com.ferreiraluizga.entities.Ocorrencia;
import com.ferreiraluizga.infrastructure.mappers.ocorrencia.OcorrenciaEntityMapper;
import com.ferreiraluizga.infrastructure.persistence.carrinho.CarrinhoEntity;
import com.ferreiraluizga.infrastructure.persistence.dispositivo.DispositivoEntity;
import com.ferreiraluizga.infrastructure.persistence.ocorrencia.OcorrenciaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DispositivoEntityMapper {

    private final OcorrenciaEntityMapper ocorrenciaEntityMapper;

    // entity -> domain
    public Dispositivo toDomain(DispositivoEntity entity) {
        if (entity == null) return null;

        List<Ocorrencia> ocorrencias = entity.getOcorrencias() != null
                ? entity.getOcorrencias().stream()
                  .map(ocorrenciaEntityMapper::toDomain)
                  .collect(Collectors.toList())
                : Collections.emptyList();

        return new Dispositivo(
                entity.getId(),
                entity.getSerial(),
                entity.getNumDispositivo(),
                entity.getModeloDispositivo(),
                entity.getSistemaOperacional(),
                entity.getAtivo(),
                entity.getObservacao(),
                entity.getManutencao(),
                new Carrinho(
                        entity.getCarrinho().getId(),
                        entity.getCarrinho().getDescricao(),
                        null
                ),
                ocorrencias
        );
    }

    // domain -> entity
    public DispositivoEntity toEntity(Dispositivo dispositivo) {
        if (dispositivo == null) return null;

        List<OcorrenciaEntity> ocorrenciasEntity = dispositivo.ocorrencias() != null
                ? dispositivo.ocorrencias().stream()
                  .map(ocorrenciaEntityMapper::toEntity)
                  .collect(Collectors.toList())
                : Collections.emptyList();

        return new DispositivoEntity(
                dispositivo.id(),
                dispositivo.serial(),
                dispositivo.numDispositivo(),
                dispositivo.modeloDispositivo(),
                dispositivo.sistemaOperacional(),
                dispositivo.ativo(),
                dispositivo.observacao(),
                dispositivo.manutencao(),
                new CarrinhoEntity(
                        dispositivo.carrinho().id(),
                        dispositivo.carrinho().descricao(),
                        null
                ),
                ocorrenciasEntity
        );
    }

}
