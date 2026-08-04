package com.ferreiraluizga.infrastructure.mappers.carrinho;

import com.ferreiraluizga.entities.Carrinho;
import com.ferreiraluizga.infrastructure.dtos.request.CarrinhoRequest;
import com.ferreiraluizga.infrastructure.dtos.response.CarrinhoResponse;
import org.springframework.stereotype.Component;

@Component
public class CarrinhoDtoMapper {

    // dto -> domain
    public Carrinho toDomain(CarrinhoRequest dto) {
        return new Carrinho(
                null,
                dto.descricao()
        );
    }

    // domain -> dto
    public CarrinhoResponse toDto(Carrinho carrinho) {
        return new CarrinhoResponse(
                carrinho.id(),
                carrinho.descricao()
        );
    }

}
