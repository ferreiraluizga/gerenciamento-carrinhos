package com.ferreiraluizga.infrastructure.persistence.dispositivo;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DispositivoRepository extends JpaRepository<DispositivoEntity, Long> {

    Optional<DispositivoEntity> findBySerial(String serial);

    @Override
    @EntityGraph(attributePaths = {"ocorrencias"})
    List<DispositivoEntity> findAll();

    @Override
    @EntityGraph(attributePaths = {"dispositivos"})
    Optional<DispositivoEntity> findById(Long id);

}
