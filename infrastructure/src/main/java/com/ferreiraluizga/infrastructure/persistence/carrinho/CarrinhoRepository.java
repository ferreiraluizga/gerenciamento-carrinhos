package com.ferreiraluizga.infrastructure.persistence.carrinho;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarrinhoRepository extends JpaRepository<CarrinhoEntity, Long> {

    @Override
    @EntityGraph(attributePaths = {"dispositivos"})
    List<CarrinhoEntity> findAll();

    @Override
    @EntityGraph(attributePaths = {"dispositivos"})
    Optional<CarrinhoEntity> findById(Long id);

}
