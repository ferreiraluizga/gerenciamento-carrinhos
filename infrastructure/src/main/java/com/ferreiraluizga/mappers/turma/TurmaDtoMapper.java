package com.ferreiraluizga.mappers.turma;

import com.ferreiraluizga.entities.Turma;
import com.ferreiraluizga.dtos.request.TurmaRequest;
import com.ferreiraluizga.dtos.response.TurmaResponse;
import org.springframework.stereotype.Component;

@Component
public class TurmaDtoMapper {

    // dto -> domain
    public Turma toDomain(TurmaRequest dto) {
        return new Turma(
                null,
                dto.nome(),
                dto.turno(),
                null
        );
    }

    // domain -> dto
    public TurmaResponse toResponse(Turma turma) {
        return new TurmaResponse(
                turma.id(),
                turma.nome(),
                turma.turno()
        );
    }

}
