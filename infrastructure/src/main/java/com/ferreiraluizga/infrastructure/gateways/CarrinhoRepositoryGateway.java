package com.ferreiraluizga.infrastructure.gateways;

import com.ferreiraluizga.entities.Carrinho;
import com.ferreiraluizga.gateways.CarrinhoGateway;
import com.ferreiraluizga.infrastructure.mappers.carrinho.CarrinhoEntityMapper;
import com.ferreiraluizga.infrastructure.persistence.carrinho.CarrinhoEntity;
import com.ferreiraluizga.infrastructure.persistence.carrinho.CarrinhoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CarrinhoRepositoryGateway implements CarrinhoGateway {

    private final CarrinhoRepository carrinhoRepository;
    private final CarrinhoEntityMapper carrinhoEntityMapper;

    @Override
    public Carrinho salvarCarrinho(Carrinho carrinho) {
        CarrinhoEntity entityResponse = carrinhoRepository.save(carrinhoEntityMapper.toEntity(carrinho));
        return carrinhoEntityMapper.toDomain(entityResponse);
    }

    @Override
    public List<Carrinho> listarCarrinhos() {
        return carrinhoRepository.findAll().stream()
                .map(carrinhoEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Carrinho> buscarCarrinhoPorId(Long id) {
        return carrinhoRepository.findById(id)
                .map(carrinhoEntityMapper::toDomain);
    }

    @Override
    public void excluirCarrinho(Long id) {
        carrinhoRepository.deleteById(id);
    }

}
