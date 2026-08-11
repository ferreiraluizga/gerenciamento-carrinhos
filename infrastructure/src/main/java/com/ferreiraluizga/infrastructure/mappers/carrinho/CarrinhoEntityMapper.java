package com.ferreiraluizga.infrastructure.mappers.carrinho;

import com.ferreiraluizga.entities.Carrinho;
import com.ferreiraluizga.entities.Dispositivo;
import com.ferreiraluizga.infrastructure.mappers.dispositivo.DispositivoEntityMapper;
import com.ferreiraluizga.infrastructure.persistence.carrinho.CarrinhoEntity;
import com.ferreiraluizga.infrastructure.persistence.dispositivo.DispositivoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CarrinhoEntityMapper {

    private final DispositivoEntityMapper dispositivoEntityMapper;

    // entity -> domain
    public Carrinho toDomain(CarrinhoEntity entity) {
        if (entity == null) return null;

        List<Dispositivo> dispositivos = entity.getDispositivos() != null
                ? entity.getDispositivos().stream()
                  .map(dispositivoEntityMapper::toDomain)
                  .collect(Collectors.toList())
                : Collections.emptyList();

        return new Carrinho(
                entity.getId(),
                entity.getDescricao(),
                dispositivos,
                null
        );
    }

    // domain -> entity
    public CarrinhoEntity toEntity(Carrinho carrinho) {
        if (carrinho == null) return null;

        List<DispositivoEntity> dispositivosEntity = carrinho.dispositivos() != null
                ? carrinho.dispositivos().stream()
                  .map(dispositivoEntityMapper::toEntity)
                  .collect(Collectors.toList())
                : Collections.emptyList();

        return new CarrinhoEntity(
                carrinho.id(),
                carrinho.descricao(),
                dispositivosEntity,
                null
        );
    }
}
