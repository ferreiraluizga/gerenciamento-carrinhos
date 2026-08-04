package com.ferreiraluizga.infrastructure.persistence.dispositivo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DispositivoRepository extends JpaRepository<DispositivoEntity, Long> {

    Optional<DispositivoEntity> findBySerial(String serial);

}
