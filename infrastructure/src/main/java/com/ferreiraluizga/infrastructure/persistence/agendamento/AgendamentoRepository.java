package com.ferreiraluizga.infrastructure.persistence.agendamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<AgendamentoEntity, Long> {
}
