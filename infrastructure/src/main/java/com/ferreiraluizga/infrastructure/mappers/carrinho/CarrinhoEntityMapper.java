package com.ferreiraluizga.infrastructure.mappers.carrinho;

import com.ferreiraluizga.entities.Carrinho;
import com.ferreiraluizga.infrastructure.persistence.carrinho.CarrinhoEntity;
import org.springframework.stereotype.Component;

@Component
public class CarrinhoEntityMapper {

    // entity -> domain
    public Carrinho toDomain(CarrinhoEntity entity) {
        return new Carrinho(
                entity.getId(),
                entity.getDescricao()
        );
    }

    // domain -> entity
    public CarrinhoEntity toEntity(Carrinho carrinho) {
        return new CarrinhoEntity(
                carrinho.id(),
                carrinho.descricao()
        );
    }

}
