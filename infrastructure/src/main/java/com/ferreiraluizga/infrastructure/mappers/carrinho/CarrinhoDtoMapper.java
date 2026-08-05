package com.ferreiraluizga.infrastructure.mappers.carrinho;

import com.ferreiraluizga.entities.Carrinho;
import com.ferreiraluizga.infrastructure.dtos.request.CarrinhoRequest;
import com.ferreiraluizga.infrastructure.dtos.response.CarrinhoResponse;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class CarrinhoDtoMapper {

    // dto -> domain
    public Carrinho toDomain(CarrinhoRequest dto) {
        return new Carrinho(
                null,
                dto.descricao(),
                Collections.emptyList()
        );
    }

    // dto -> domain (put)
    public Carrinho toDomain(Long id, CarrinhoRequest dto) {
        return new Carrinho(
                id,
                dto.descricao(),
                Collections.emptyList()
        );
    }

    // domain -> dto
    public CarrinhoResponse toDto(Carrinho carrinho) {
        int quantDispositivos = (carrinho.dispositivos() != null) ? carrinho.dispositivos().size() : 0;

        return new CarrinhoResponse(
                carrinho.id(),
                carrinho.descricao(),
                quantDispositivos
        );
    }

}
