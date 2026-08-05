package com.ferreiraluizga.infrastructure.mappers.dispositivo;

import com.ferreiraluizga.entities.Carrinho;
import com.ferreiraluizga.entities.Dispositivo;
import com.ferreiraluizga.infrastructure.persistence.carrinho.CarrinhoEntity;
import com.ferreiraluizga.infrastructure.persistence.dispositivo.DispositivoEntity;
import org.springframework.stereotype.Component;

@Component
public class DispositivoEntityMapper {

    // entity -> domain
    public Dispositivo toDomain(DispositivoEntity entity) {
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
                )
        );
    }

    // domain -> entity
    public DispositivoEntity toEntity(Dispositivo dispositivo) {
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
                )
        );
    }

}
