package com.ferreiraluizga.infrastructure.persistence.ocorrencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcorrenciaRepository extends JpaRepository<OcorrenciaEntity, Long> {
}
