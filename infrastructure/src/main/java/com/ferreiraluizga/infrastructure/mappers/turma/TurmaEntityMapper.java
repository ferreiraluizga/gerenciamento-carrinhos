package com.ferreiraluizga.infrastructure.mappers.turma;

import com.ferreiraluizga.entities.Turma;
import com.ferreiraluizga.infrastructure.persistence.turma.TurmaEntity;
import org.springframework.stereotype.Component;

@Component
public class TurmaEntityMapper {

    // entity -> domain
    public Turma toDomain(TurmaEntity entity) {
        return new Turma(
                entity.getId(),
                entity.getNome(),
                entity.getTurno()
        );
    }

    // domain -> entity
    public TurmaEntity toEntity(Turma turma) {
        return new TurmaEntity(
                turma.id(),
                turma.nome(),
                turma.turno()
        );
    }

}
